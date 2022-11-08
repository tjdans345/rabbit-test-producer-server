//package com.example.rabbittestserver.rabbit.config.common;
//
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * publisher, subscriber 모두에게 적용되는 내용.
// * Exchange 는 publisher 의 메시지를 subscriber 가 수신하는 곳이다.
// * 즉 publisher 와 subscriber 모두에게 필요한 정의
// */
//@Configuration
//public class PubSubConfig {
//
//    // exchange 정의
//    @Bean
//    public FanoutExchange exchange() {
//        return new FanoutExchange(RabbitMqConstants.EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//}
