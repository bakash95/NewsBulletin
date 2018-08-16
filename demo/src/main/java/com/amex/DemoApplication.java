package com.amex;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.amex.rest", "com.amex.dao", "com.amex.service" })
public class DemoApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(DemoApplication.class, args);
	}
}
