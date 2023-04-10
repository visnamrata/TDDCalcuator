package com.calculator.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TddApplicationTests {

	public StringCalculator calculator;

	@Test
	void contextLoads() {
	}

	public void checkForEmptyString()
	{
		int result=calculator.add("");
		assertEquals(0,result);
	}

}
