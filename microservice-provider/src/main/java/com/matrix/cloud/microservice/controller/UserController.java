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
import com.matrix.cloud.microservice.entity.ConfigDemo;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.repository.UserRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/user" )
public class UserController
{
    private static Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfigDemo configDemo;

    @ApiOperation( value = "获取用户信息", notes = "根据用户id，获取用户信息" )
    @ApiImplicitParam( name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long" )
    @GetMapping( value = "/{id}", produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<User> findById( @PathVariable( "id" ) Long id )
    {

        // 接口日志1： request信息
        logger.info( "/user/{} findById()", id );

        try
        {
            User user = userRepository.findOne( id );

            // 接口日志2： response信息
            logger.info( "/user/{id} findById() return : User={}", JSON.toJSONString( user ) );
            return new ResponseEntity<User>( user );
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

    @ApiOperation( value = "获取配置信息", notes = "获取配置信息" )
    @GetMapping( value = "/getConfigDemo", produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<ConfigDemo> getConfigDemo()
    {
        return new ResponseEntity<ConfigDemo>( configDemo );
    }
}
