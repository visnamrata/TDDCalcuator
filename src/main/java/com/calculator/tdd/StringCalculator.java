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

         else {
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }

            String[] numList =  numbers.split(delimiter + "|\n");
            int total = 0;
            StringBuilder negativeString = new StringBuilder();

            for (String number : numList) {
                if (Integer.parseInt(number) < 0) {
                    if (negativeString.toString().equals(""))
                        negativeString = new StringBuilder(number);
                    else
                        negativeString.append(",").append(number);
                }
                if (Integer.parseInt(number) < 1000)
                    total += Integer.parseInt(number);
            }

            if (!negativeString.toString().equals("")) {
                throw new IllegalArgumentException("Negatives numbers are not allowed: " + negativeString);
            }
            return total;
        }
    }
}
