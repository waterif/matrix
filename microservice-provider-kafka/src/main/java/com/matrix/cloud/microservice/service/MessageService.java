package com.matrix.cloud.microservice.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageService
{

    /**
     * 消息生产者
     */
    String MESSAGE_OUTPUT = "matrix";

    /**
     * 消息消费者
     */
    String MESSAGE_INPUT = "matrix";

    @Output( MESSAGE_OUTPUT )
    MessageChannel messageOutput();

    @Input( MESSAGE_INPUT )
    SubscribableChannel messageInput();
}
