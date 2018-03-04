package com.matrix.cloud.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.cloud.common.base.BaseException;
import com.matrix.cloud.common.base.ErrorCode;
import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.message.MessageProducer;

@RestController
@RequestMapping( "/hello" )
public class HelloController
{
    private static Logger logger = LoggerFactory.getLogger( HelloController.class );

    @Autowired
    private MessageProducer message;


    @GetMapping( value = "/{msg}", produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<Boolean> hello( @PathVariable( "msg" ) String msg )
    {

        // 接口日志1： request信息
        logger.info( "/hello/{}", msg );

        try
        {
            message.sendMessage( "hello " + msg );

            // 接口日志2： response信息
            logger.info( "/hello/{} return : {}", msg, true );
            return new ResponseEntity<Boolean>( true );
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<Boolean>( ErrorCode.ERROR_COMMON_FAILURE );
        }

    }
}
