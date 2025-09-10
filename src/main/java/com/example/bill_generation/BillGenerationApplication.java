package com.example.bill_generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class BillGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillGenerationApplication.class, args);
	}

}
