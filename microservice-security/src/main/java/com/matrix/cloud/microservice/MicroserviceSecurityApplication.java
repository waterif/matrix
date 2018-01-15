package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceSecurityApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceSecurityApplication.class, args );
    }
}
