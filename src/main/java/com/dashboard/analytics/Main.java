package com.dashboard.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.dashboard.analytics")
public class Main {

	public static void main(String[] args) {

		// Database db = new Database();

		SpringApplication.run(Main.class, args);

	}
}
