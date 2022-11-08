package com.example.rabbittestserver.rabbit.controller;

import com.example.rabbittestserver.rabbit.domain.dto.MessageDTO;
import com.example.rabbittestserver.rabbit.service.RabbitSimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/api/rabbit")
@RequiredArgsConstructor
@RestController
public class RabbitSimpleController {

    private final RabbitSimpleService rabbitSimpleService;

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    /**
     * RabbitMQ 메시지 발행
     * @param messageDTO messageDTO
     * @return HttpEntity
     */
//    @PostMapping("/message")
//    public HttpEntity<String>sendMessage(@RequestBody MessageDTO messageDTO) {
//        return ResponseEntity.ok()
//                .body(rabbitSimpleService.sendMessage(messageDTO));
//    }


}
