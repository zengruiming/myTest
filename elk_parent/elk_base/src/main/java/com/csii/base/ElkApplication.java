package com.csii.base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import util.IdWorker;


@SpringBootApplication
@EnableSwagger2
public class ElkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElkApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
