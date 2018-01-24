package com.matrix.cloud.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**   
* @Description: TODO(这里用一句话描述这个类的作用) 
*  
* http://localhost:8080/swagger-ui.html
* 
* @author matrix 
* @date 2018年1月14日  下午6:15:52
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket createRestApi()
    {
        ApiInfo apiInfo = new ApiInfoBuilder().title( "使用Swagger2构建RESTful APIs" ).description( "客户端与服务端接口文档" )
                .build();

        return new Docket( DocumentationType.SWAGGER_2 ).apiInfo( apiInfo ).select()
                .apis( RequestHandlerSelectors.basePackage( "com.matrix.cloud.microservice.controller" ) ).paths( PathSelectors.any() )
                .build();
    }

}
