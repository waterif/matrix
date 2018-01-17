package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
//@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceTurbineApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceTurbineApplication.class, args );
    }
}
