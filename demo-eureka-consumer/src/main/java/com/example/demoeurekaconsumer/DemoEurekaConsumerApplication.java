package com.example.demoeurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.example.demoeurekaconsumer.config.RibbonConfiguration;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "server", configuration = RibbonConfiguration.class)
public class DemoEurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaConsumerApplication.class, args);
	}

}
