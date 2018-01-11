package com.matrix.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceConsumerKafkaApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MicroserviceConsumerKafkaApplication.class, args );
    }
}