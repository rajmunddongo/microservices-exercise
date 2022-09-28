package com.rajmi.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey){
        log.info("Beginning to publish payload, with exhange: {} and routingkey: {}",exchange,routingKey);
        amqpTemplate.convertAndSend(exchange,routingKey,payload);
        log.info("Payload published, with exhange: {} and routingkey: {}",exchange,routingKey);
    }
}
