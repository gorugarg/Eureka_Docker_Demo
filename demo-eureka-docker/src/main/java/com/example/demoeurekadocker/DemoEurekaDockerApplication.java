package com.example.demoeurekadocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoEurekaDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaDockerApplication.class, args);
	}

}
