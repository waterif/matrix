package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@ServletComponentScan( basePackages = { "com.matrix.cloud.common.filter" } )
public class MicroserviceDiscoveryEurekaApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceDiscoveryEurekaApplication.class, args );
        // new SpringApplicationBuilder(MicroserviceDiscoveryEurekaApplication.class).web(true).run(args);
    }
}
