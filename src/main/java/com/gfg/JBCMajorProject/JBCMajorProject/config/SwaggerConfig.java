package com.gfg.JBCMajorProject.JBCMajorProject.config;

import com.gfg.JBCMajorProject.JBCMajorProject.controller.TwitterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gfg.JBCMajorProject.JBCMajorProject"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
}
    private ApiInfo metaInfo(){

        ApiInfo apiInfo=new ApiInfo(
                "SpringBoot Swagger API ",
                "Swagger Page for Twitter REST APIs",
                "1.0",
                "Terms of Service",
                new Contact("Nikhil","http://localhost:8082/rest/timeline","nikhil.srivastava944@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",
                new ArrayList()
        );
        return apiInfo;
    }

}
