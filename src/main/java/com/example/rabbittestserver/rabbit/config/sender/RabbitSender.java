package com.example.rabbittestserver.rabbit.config.sender;

import com.example.rabbittestserver.rabbit.domain.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ 는 메시지 발행 / 구독을 통하여 작업을 수행할 수 있는 메시지 큐잉 시스템
 */
@Component
@RequiredArgsConstructor
public class RabbitSender {
    private final RabbitMessagingTemplate template;

//    @Bean
//    Queue queue() {
//        return new Queue("chat", false);
//    }

    /**
     * RabbitMQ 메시지 발행
     * @param messageDTO messageDTO
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(MessageDTO messageDTO) {
        System.out.println("실행..");
        template.convertAndSend("/chat" , messageDTO.toString());
    }

}



