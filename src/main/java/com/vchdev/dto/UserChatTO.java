package com.vchdev.dto;

import com.vchdev.dao.entity.Chat;
import com.vchdev.dao.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChatTO extends BaseTO<Long> {
    private User user;
    private Chat chat;
}
