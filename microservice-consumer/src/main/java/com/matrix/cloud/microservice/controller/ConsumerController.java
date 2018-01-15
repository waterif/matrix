package com.matrix.cloud.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.matrix.cloud.common.base.BaseException;
import com.matrix.cloud.common.base.ErrorCode;
import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.UserService;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月15日  下午6:21:49
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
@RestController
@RequestMapping( "/user" )
public class ConsumerController
{
    private static Logger logger = LoggerFactory.getLogger( ConsumerController.class );

    @Autowired
    private UserService userService;

    @GetMapping( value = "/{id}", produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<User> findById( @PathVariable( "id" ) Long id )
    {

        // 接口日志1： request信息
        logger.info( "/user/{} findById()", id );

        try
        {
            ResponseEntity<User> user = userService.getUser( id );

            // 接口日志2： response信息
            logger.info( "/user/{id} findById() return : User={}", JSON.toJSONString( user ) );
            return user;
        }
        catch ( BaseException e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<User>( e.getErrorCode(), e.getMessage() );
        }
        catch ( Exception e )
        {
            // 异常日志
            logger.error( e.getMessage(), e );
            return new ResponseEntity<User>( ErrorCode.ERROR_COMMON_FAILURE );
        }
    }
}
