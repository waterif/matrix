package com.matrix.cloud.microservice.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class EurekaEventListener
{
    private static Logger logger = LoggerFactory.getLogger( EurekaEventListener.class );

    /**
     * 服务下线事件
     * @param event
     */
    @EventListener
    public void listen( EurekaInstanceCanceledEvent event )
    {
        logger.info( "服务下线事件: {}", JSON.toJSONString( event ) );
    }

    /**
     * 服务注册事件
     * @param event
     */
    @EventListener
    public void listen( EurekaInstanceRegisteredEvent event )
    {
        logger.info( "服务注册事件: {}", JSON.toJSONString( event ) );
    }

    /**
     * 服务续约事件
     * @param event
     */
    @EventListener
    public void listen( EurekaInstanceRenewedEvent event )
    {
        logger.info( "服务续约事件: {}", JSON.toJSONString( event ) );
    }

    /**
     * 注册中心启动事件
     * @param event
     */
    @EventListener
    public void listen( EurekaRegistryAvailableEvent event )
    {
        logger.info( "注册中心启动事件: {}", JSON.toJSONString( event ) );
    }

    /**
     * 启动事件
     * @param event
     */
    @EventListener
    public void listen( EurekaServerStartedEvent event )
    {
        logger.info( "启动事件: {}", JSON.toJSONString( event ) );
    }
}
