package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
//@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceHystrixDashboardApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceHystrixDashboardApplication.class, args );
    }
}
