package com.vchdev.services;

import com.vchdev.dao.UserChatRepository;
import com.vchdev.dao.entity.UserChat;
import org.springframework.stereotype.Service;

@Service
public class UserChatService extends AbstractService<UserChat, UserChatRepository> {
    public UserChatService(UserChatRepository repository) {
        super(repository);
    }
}
