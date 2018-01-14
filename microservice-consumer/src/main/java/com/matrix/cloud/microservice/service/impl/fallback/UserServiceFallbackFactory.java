package com.matrix.cloud.microservice.service.impl.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.UserService;

import feign.hystrix.FallbackFactory;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( UserServiceFallbackFactory.class );

    @Override
    public UserService create( Throwable e )
    {
        LOGGER.error( "fallback message: {}", e.getMessage() );

        return new UserService()
        {

            @Override
            public ResponseEntity<User> getUser( Long id )
            {
                User user = new User();
                user.setId( -1L );
                user.setUsername( "fallback" );
                return new ResponseEntity<User>( user );
            }

        };
    }

}
