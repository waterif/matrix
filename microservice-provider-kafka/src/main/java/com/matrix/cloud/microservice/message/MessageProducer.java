package com.matrix.cloud.microservice.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import com.alibaba.fastjson.JSON;
import com.matrix.cloud.microservice.service.MessageService;

@EnableBinding( MessageService.class )
public class MessageProducer
{
    @Autowired
    private MessageService messageService;

    public void sendMessage( Object message )
    {
//        messageService.messageOutput().send( MessageBuilder.withPayload( JSON.toJSONString( message ) ).build() );
        messageService.messageOutput().send( MessageBuilder.withPayload( message ).build() );
    }
}
