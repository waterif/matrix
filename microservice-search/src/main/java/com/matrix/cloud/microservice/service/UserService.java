package com.matrix.cloud.microservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matrix.cloud.common.base.ResponseEntity;
import com.matrix.cloud.microservice.entity.User;
import com.matrix.cloud.microservice.service.impl.fallback.UserServiceFallbackFactory;

/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author matrix  
* @date 2018年1月14日  下午12:08:59
*    
*/  
//@FeignClient( name = "microservice-provider", fallback = UserServiceImpl.class )
@FeignClient( name = "microservice-provider", fallbackFactory = UserServiceFallbackFactory.class )
public interface UserService
{
    /**
     * <方法概述>
     * @param id
     * @return User
     */
    @RequestMapping( value = "/user/{id}", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" } )
    public ResponseEntity<User> getUser( @PathVariable( "id" ) Long id );
}
