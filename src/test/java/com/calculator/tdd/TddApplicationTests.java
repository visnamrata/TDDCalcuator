package com.calculator.tdd;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class )
class TddApplicationTests {
	@Autowired
	public StringCalculator calculator;
	@Test
	public void checkForEmptyString()
	{
		int actual_result=calculator.add("");
		assertEquals(0,actual_result);
	}

	@Test
	public void testAddOneNumber() {
		int actual_result=calculator.add("1");
		assertEquals(1,actual_result);
	}

	@Test
	public void testNewLine() {
		assertEquals(10, calculator.add("1\n2,3\n4"));
	}

	@Test
	public void testNegativeNumber() {
		try {
			calculator.add("-1,2");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negatives numbers are not allowed: -1");
		}
		try {
			calculator.add("1,-2,3,-5");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negatives numbers are not allowed: -2,-5");
		}
	}

	@Test
	public void testAddMultipleNumbers() {
		assertEquals(3, calculator.add("1,2"));
	}

	@Test
	public void testOverThousand() {
		assertEquals(10, calculator.add("1000,10"));
	}

	@Test
	public void testOtherDelimiter() {
		assertEquals(3, calculator.add("//;\n1;2"));
	}

}
