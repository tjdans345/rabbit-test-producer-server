//package com.example.rabbittestserver.rabbit.config;
//
//import com.example.rabbittestserver.rabbit.config.common.RabbitMqConstants;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import javax.sound.midi.Receiver;
//
//// subscriber 는 exchange, queue 그리고 둘을 매핑하는 binding 을 모두 정의한다.
//@Configuration
//public class ReceiverConfig {
//
//    // durable, non-exclusive, non-autoDelete queue 1개 선언.
//    @Bean
//    public Queue queue() {
//        return new Queue(RabbitMqConstants.QUEUE_NAME);
//    }
//
//    // exchange 와 queue 를 binding 해준다.
//    // 즉, exchange 에서 데이터를 꺼내올 Queue 정의는 Receiver 의 책임이다.
//    @Bean
//    public Binding binding(FanoutExchange exchange, Queue testQueue) {
//        return BindingBuilder.bind(testQueue).to(exchange);
//    }
//
//    // 정의된 메세지 리스너를 적용
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setQueueNames(RabbitMqConstants.QUEUE_NAME);
//        container.setMessageListener(messageListenerAdapter);
//        return container;
//    }
//
//    // 메시지 리스너를 정의한다. Subscriber 에 대한 설정 등.
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver,
//                                           Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receive");
//        messageListenerAdapter.setDefaultListenerMethod("receive"); // 실행할 메소드 지정.
//        messageListenerAdapter.setMessageConverter(jackson2JsonMessageConverter); // Json형태로 받기 위해 MessageConverter 설정.
//        return messageListenerAdapter;
//    }
//
//
//}
