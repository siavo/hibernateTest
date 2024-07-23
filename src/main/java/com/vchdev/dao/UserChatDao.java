package com.vchdev.dao;

import com.vchdev.dao.entity.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatDao extends JpaRepository<UserChat, Long> {
}
