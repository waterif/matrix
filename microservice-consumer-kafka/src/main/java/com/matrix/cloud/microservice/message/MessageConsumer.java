package com.matrix.cloud.microservice.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.matrix.cloud.microservice.service.MessageService;

@EnableBinding( MessageService.class )
public class MessageConsumer
{
    private static Logger logger = LoggerFactory.getLogger( MessageConsumer.class );

    @StreamListener( MessageService.MESSAGE_INPUT )
    public void receiveMessage( Message<String> message )
    {
        logger.info( "接收消息，参数={}", JSON.toJSONString( message ) );
        
        if ( null == message )
        {
            return;
        }

        try
        {
            String payload = message.getPayload();

            logger.info( "具体消息内容= {}", JSONObject.toJSONString( payload ) );

            // JSONObject jsonObject = JSON.parseObject( payload );

        }
        catch ( Exception e )
        {
            logger.error( "接收处理货柜模板MQ时出现异常:{}", e );
            // throw new RuntimeException( e );
        }
    }
}
