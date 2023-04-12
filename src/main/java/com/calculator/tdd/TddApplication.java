package com.calculator.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TddApplication {

	public static void main(String[] args) {
		StringCalculator calculator = new StringCalculator();
		SpringApplication.run(TddApplication.class, args);

		int result=calculator.add("1,2,3");
		System.out.println(result);
	}

}
