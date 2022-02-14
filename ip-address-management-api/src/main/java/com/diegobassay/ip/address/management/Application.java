package com.diegobassay.ip.address.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan({"com.diegobassay.ip.address.management.domain.entity"} )
@EnableJpaRepositories("com.diegobassay.ip.address.management.*")
@ComponentScan(basePackages={"com.diegobassay.ip.address.management.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}