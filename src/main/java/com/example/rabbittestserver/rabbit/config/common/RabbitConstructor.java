package com.example.rabbittestserver.rabbit.config.common;

public class RabbitConstructor {

    // 큐 이름 설정 값
    public static final String CHAT_QUEUE_NAME = "meteor.queue";
//    public static final String CHAT_QUEUE_NAME = "meteorMeteor.queue";
    // Exchange 이름 설정 값
    public static final String CHAT_EXCHANGE_NAME = "meteor.exchange";
    // RoutingKey 값
    public static final String ROUTING_KEY = "room.*";

}


