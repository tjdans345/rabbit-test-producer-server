//package com.example.rabbittestserver.rabbit.config.common;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties(prefix = "spring.rabbitmq")
//@Getter @Setter
//public class RabbitMQProperty {
//
//    private RabbitMqDetailProperty rabbitMqDetailProperty;
//
//    @Getter @Setter
//    public static class RabbitMqDetailProperty {
//        private String username;
//        private String password;
//        private String host;
//        private int port;
//        private String virtualHost;
//        private RabbitTemplate rabbitTemplate;
//        private String queueName;
//        private String deadLetterExchange;
//        private String deadLetterRouteKey;
//    }
//
//    @Getter @Setter
//    public static class RabbitTemplate {
//        private String routeKey;
//        private String exchangeName;
//    }
//
//
//}
