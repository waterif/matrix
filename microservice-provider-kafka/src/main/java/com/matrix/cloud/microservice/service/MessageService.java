package com.matrix.cloud.microservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageService
{

    /**
     * 消息生产者
     */
    String MESSAGE_OUTPUT = "channelOutput";

    @Output( MESSAGE_OUTPUT )
    MessageChannel messageOutput();

}
