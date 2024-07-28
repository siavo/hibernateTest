package com.vchdev.dao;

import com.vchdev.dao.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CommonRepository<Chat> {
}
