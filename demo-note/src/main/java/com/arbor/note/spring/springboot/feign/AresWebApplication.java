package com.arbor.note.spring.springboot.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.arbor.note.spring.*"})
public class AresWebApplication {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {



		SpringApplication.run(AresWebApplication.class, args);
	}

}
