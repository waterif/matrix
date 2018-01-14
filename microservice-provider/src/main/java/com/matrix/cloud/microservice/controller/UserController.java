package com.matrix.cloud.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.cloud.microservice.entity.ConfigDemo;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.repository.UserRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/user" )
public class UserController
{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ConfigDemo configDemo;

    @ApiOperation( value = "获取用户信息", notes = "根据用户id，获取用户信息" )
    @ApiImplicitParam( name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long" )
    @GetMapping( value = "/{id}", produces = { "application/json; charset=UTF-8" } )
    public User findById( @PathVariable( "id" ) Long id )
    {
        logger.debug( "debug--> start findById. /user/{}", id );
        logger.info( "info--> start findById. /user/{}", id );
        
        User findOne = userRepository.findOne( id );
        
        logger.info( "info--> end findById. /user/{}", id );
        
        return findOne;
    }
    
    @ApiOperation( value = "获取配置信息", notes = "获取配置信息" )
    @GetMapping( value = "/getConfigDemo", produces = { "application/json; charset=UTF-8" } )
    public ConfigDemo getConfigDemo( )
    {
        return configDemo;
    }
}
