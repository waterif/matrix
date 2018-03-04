package com.matrix.cloud.microservice.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {Sink.class})//用来指定一个或多个定义了@Input 或者 @Output注解的接口，实现对消息通道的绑定。Sink接口是默认输入消息通道绑定接口
public class SinkReceiver
{
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    

    @StreamListener(Sink.INPUT)//将被修饰的方法注册为消息中间件上数据流的事件监听器，
    public void receive( Object payload )
    {
        logger.info( "Received: " + payload );
    }
}
