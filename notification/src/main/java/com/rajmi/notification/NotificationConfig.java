package com.rajmi.notification;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queue.notification}")
    private String queueNotification;
    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String notificationRoutingKey;

    public String getInternalExchange(){
        return internalExchange;
    }

    public Queue notificationQueue(){
        return new Queue(this.queueNotification);
    }
    public TopicExchange internalExchange(){
        return new TopicExchange(this.internalExchange);
    }
    public Binding queueBinding(){
        return BindingBuilder
                .bind(this.notificationQueue())
                .to(this.internalExchange())
                .with(notificationRoutingKey);
    }

}
