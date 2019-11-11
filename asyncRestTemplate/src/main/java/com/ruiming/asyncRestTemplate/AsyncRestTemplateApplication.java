package com.ruiming.asyncRestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication
@Configuration
public class AsyncRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncRestTemplateApplication.class,args);
    }

    /**
     * 注册ObjectMapper
     * @return
     */
    @Bean
    public ObjectMapper ObjectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper;
    }

    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        return new AsyncRestTemplate();
    }

}
