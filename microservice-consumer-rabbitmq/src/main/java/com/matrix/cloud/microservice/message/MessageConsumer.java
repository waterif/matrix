package com.matrix.cloud.microservice.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.matrix.cloud.microservice.service.MessageService;

@EnableBinding( MessageService.class )
public class MessageConsumer
{
    @StreamListener( MessageService.MESSAGE_INPUT )
    public void receiveMessage( Message<String> message )
    {
        // log.info("接收货柜模板开始，参数={}", JSON.toJSONString(message));
        if ( null == message )
        {
            return;
        }
        try
        {
            String payload = message.getPayload();

            // log.info("具体消息内容= {}", JSONObject.toJSONString(payload));

            JSONObject jsonObject = JSON.parseObject( payload );
            
        }
        catch ( Exception e )
        {
//            log.error( "接收处理货柜模板MQ时出现异常:{}", e );
            throw new RuntimeException( e );
        }
    }
}
