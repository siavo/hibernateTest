package com.vchdev.dao;

import com.vchdev.dao.entity.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatRepository extends CommonRepository<UserChat> {
}
