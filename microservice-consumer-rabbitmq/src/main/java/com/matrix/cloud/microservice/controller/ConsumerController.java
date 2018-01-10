package com.matrix.cloud.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.UserService;

@RestController
@RequestMapping( "/user" )
public class ConsumerController
{
    @Autowired
    private UserService userService;

    @GetMapping( value = "/{id}", produces = { "application/json; charset=UTF-8" } )
    public User findById( @PathVariable( "id" ) Long id )
    {
        User findOne = userService.getUser( id );
        return findOne;
    }
}
