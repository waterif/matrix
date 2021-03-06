package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceConfigApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceConfigApplication.class, args );
    }
}
