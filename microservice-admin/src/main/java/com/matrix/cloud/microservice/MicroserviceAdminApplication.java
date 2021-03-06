package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class MicroserviceAdminApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceAdminApplication.class, args );
    }
}
