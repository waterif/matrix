package com.matrix.cloud.microservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.impl.fallback.UserServiceFallbackFactory;

//@FeignClient( name = "microservice-provider", fallback = UserServiceImpl.class )
@FeignClient( name = "microservice-provider", fallbackFactory = UserServiceFallbackFactory.class )
public interface UserService
{
    @RequestMapping( value = "/user/{id}", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" } )
    public User getUser( @PathVariable( "id" ) Long id );
}
