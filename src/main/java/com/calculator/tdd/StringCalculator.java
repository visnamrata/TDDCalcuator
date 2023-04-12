package com.calculator.tdd;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty())
        {
            return 0;
        }
        if (numbers.length() < 2) {
            return Integer.parseInt(numbers);
        }
        String numList= Arrays.toString(numbers.split(","));
        return 0;
    }
}
