package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
@EnableAsync
public class MicroserviceZipkinDashboardApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceZipkinDashboardApplication.class, args );
    }

}
