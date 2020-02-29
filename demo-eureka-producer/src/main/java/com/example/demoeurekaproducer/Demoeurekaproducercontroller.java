package com.example.demoeurekaproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demoeurekaproducercontroller {

	@GetMapping("/display")
	public String display()
	{
		System.out.println("HIIIIIIII");
		return "hello world";
	}
}
