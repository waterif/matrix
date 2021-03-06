package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceProguardApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceProguardApplication.class, args );
    }
}
