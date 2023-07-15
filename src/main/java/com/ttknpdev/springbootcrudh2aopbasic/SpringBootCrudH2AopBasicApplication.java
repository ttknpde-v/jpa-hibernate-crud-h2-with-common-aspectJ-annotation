package com.ttknpdev.springbootcrudh2aopbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true) // It enables support for handling components marked with AspectJ’s @Aspect annotation.
public class SpringBootCrudH2AopBasicApplication {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    public static void main(String[] args) {

        SpringApplication.run(SpringBootCrudH2AopBasicApplication.class, args);

    }

}
