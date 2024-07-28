package com.vchdev.services;

import com.vchdev.dao.ChatRepository;
import com.vchdev.dao.entity.Chat;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends AbstractService<Chat, ChatRepository> {
    public ChatService(ChatRepository repository) {
        super(repository);
    }
}
