package com.duong.demo._web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket apiWeb() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-web-test")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.duong.demo._web.rest.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(webInfor());
    }
    private ApiInfo webInfor(){
        return new ApiInfo("Web-Infor-Title",
                "Description",
                "Version test",
                "term of service url",
                null,
                "License of API", "", Collections.emptyList());
    }
}
