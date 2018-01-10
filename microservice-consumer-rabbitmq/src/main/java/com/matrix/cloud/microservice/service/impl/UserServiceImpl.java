package com.matrix.cloud.microservice.service.impl;

import org.springframework.stereotype.Component;

import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.UserService;

@Component
public class UserServiceImpl implements UserService
{

    @Override
    public User getUser( Long id )
    {
        User user = new User();
        user.setId( -1L );
        user.setUsername( "fallback" );
        return user;
    }

}
