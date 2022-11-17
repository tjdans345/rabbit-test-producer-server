package com.example.rabbittestserver.rabbit.config;

import com.example.rabbittestserver.rabbit.config.common.RabbitConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// subscriber 는 exchange, queue 그리고 둘을 매핑하는 binding 을 모두 정의한다.
@Configuration
public class RabbitConfig {

//    private static final String CHAT_QUEUE_NAME = "chat.queue";
//    private static final String CHAT_EXCHANGE_NAME = "chat.exchange";
//    private static final String ROUTING_KEY = "room.*";

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.port}")
    private int port;

    // Queue 등록
    @Bean
    public Queue queue() {
        return new Queue(RabbitConstructor.CHAT_QUEUE_NAME, true);
    }

    // Exchange 등록
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(RabbitConstructor.CHAT_EXCHANGE_NAME);
    }

    // Exchange 와 Queue 바인딩
    // Binding: 예제에서는 BindingBuilder 를 사용해서 위에서 설정한 Queue 와 Exchange 를 바인딩 시킨다.
    // with 로 들어가는 값은 RoutingKey 로 room.하위의 모든 키들과 관계를 맺는다. ( 라우팅 키 값 : room.*)
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(RabbitConstructor.ROUTING_KEY);
    }

    @Bean
    public  com.fasterxml.jackson.databind.Module dateTimeModule() {
        return new JavaTimeModule();
    }


    // Spring 에서 자동생성해주는 ConnectionFactory 는 SimpleConnectionFactory
    // 여기서 사용하는 건 CachingConnectionFactory 라 새로 등록해줌
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPort(port);
        return factory;
    }

    /**
     * messageConverter 를 커스터마이징 하기 위해 Bean 새로 등록
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.setRoutingKey(RabbitConstructor.CHAT_QUEUE_NAME);
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer container() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(RabbitConstructor.CHAT_QUEUE_NAME);
        return container;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        //LocalDateTime serializable 을 위해
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        objectMapper.registerModule(dateTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }




}
