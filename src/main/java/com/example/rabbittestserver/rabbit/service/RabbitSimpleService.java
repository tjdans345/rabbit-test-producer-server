package com.example.rabbittestserver.rabbit.service;

import com.example.rabbittestserver.rabbit.domain.dto.MessageDTO;
import com.example.rabbittestserver.rabbit.config.sender.RabbitSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitSimpleService {

    private final RabbitSender rabbitSender;


    /**
     * RabbitMQ 메시지 발행
     * @param messageDTO messageDTO
     * @return 성공 메세지
     */
    public String sendMessage (MessageDTO messageDTO) {
      log.info("chatRoom : {} ", messageDTO.getChatRoomId());
      log.info("sender : {} ", messageDTO.getMemberId());
      try {
          rabbitSender.send(messageDTO);
          return "메시지 전송에 성공 하였습니다. ";
      } catch (Exception e) {
          log.info("Exception 발생 : {}", e.getMessage());
          return "메시지 전송에 실패하였습니다.";
      }
    }

}
