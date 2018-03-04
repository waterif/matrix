package com.matrix.cloud.microservice.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageService
{

    /**
     * 消息消费者
     */
    String MESSAGE_INPUT = "channelInput";

    @Input( MESSAGE_INPUT )
    SubscribableChannel messageInput();
}
