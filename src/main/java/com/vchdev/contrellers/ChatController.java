package com.vchdev.contrellers;

import com.vchdev.dao.entity.Chat;
import com.vchdev.dto.BaseTO;
import com.vchdev.dto.ChatTO;
import com.vchdev.services.ChatService;
import com.vchdev.util.EntityConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("chat")
public class ChatController {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List> findAll() {
        List<BaseTO> chats = new ArrayList<>();
        try{
            chats = EntityConverter.convertToDTOs(service.findAll());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.noContent().build();
        } return ResponseEntity.ok(chats);
    }

    @PostMapping("/add")
    public ResponseEntity<ChatTO> add(@RequestBody ChatTO chatTO){
        try{
            chatTO = (ChatTO) EntityConverter.convertToDto(service.saveOrUpdate((Chat) EntityConverter.convertToEntity(chatTO)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } return new ResponseEntity<>(chatTO, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ChatTO chatTO){

        service.saveOrUpdate((Chat) EntityConverter.convertToEntity(chatTO));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            service.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity("Can not delete company id:" + id, HttpStatus.NOT_ACCEPTABLE);
        } return ResponseEntity.noContent().build();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<ChatTO> findById(@PathVariable Long id){
        ChatTO chatTO = null;
        try {
            chatTO = (ChatTO) EntityConverter.convertToDto(service.findById(id).get());
        } catch (Exception e) {
            log.error(e.getMessage());
            new ResponseEntity("Chat id:" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(chatTO);
    }
}
