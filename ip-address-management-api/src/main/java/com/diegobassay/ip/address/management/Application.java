package com.diegobassay.ip.address.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.diegobassay.ip.address.management.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
