package com.matrix.cloud.microservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageService
{

    @Output( "matrix_message_output" )
    MessageChannel messageOutput();
}
