package com.vchdev.dao.entity;

import lombok.*;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "user_chat")
public class UserChat extends BaseEntity<Long> {

    @ManyToOne
    private User user;

    @ManyToOne
    private Chat chat;

    public void setChat(Chat chat) {
        this.chat = chat;
        this.chat.getUserChats().add(this);

    }

    public void setUser(User user) {
        this.user = user;
        this.user.getUserChats().add(this);

    }
}
