package com.example.rabbittestserver.rabbit.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MessageDTO {

    private String chatRoomId;
    private ContentMessageDTO contentMessageDTO;

    @Getter @Setter
    public static class ContentMessageDTO {

        private String sender;
        private String content;
        private String productId;
    }

}
