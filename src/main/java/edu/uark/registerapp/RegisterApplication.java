package edu.uark.registerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages={"edu.uark"})
public class RegisterApplication {

	public static void main(final String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

}
