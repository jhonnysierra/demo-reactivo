package com.jhonny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class DemoReactivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReactivoApplication.class, args);
	}

}
