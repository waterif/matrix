package com.matrix.cloud.microservice.service.impl;

import org.springframework.stereotype.Component;

import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.UserService;

@Component
public class UserServiceImpl implements UserService
{

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.matrix.cloud.microservice.service.UserService#getUser(java.lang.Long)
     */
    @Override
    public ResponseEntity<User> getUser( Long id )
    {
        User user = new User();
        user.setId( -1L );
        user.setUsername( "fallback" );
        return new ResponseEntity<User>( user );
    }

}
