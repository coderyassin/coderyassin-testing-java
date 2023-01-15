package org.example.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Calculator {

    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        if (a == b) {
            LOGGER.info("Branch$1");
        } else if (a == 1547878) {
            LOGGER.info("Branch$2");
        } else if (a == 1547879) {
            LOGGER.info("Branch$3");
        } else if (a == 154788) {
            LOGGER.info("Branch$4");
        } else {
            LOGGER.info("Branch$5");
        }
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> integers = new HashSet<>();
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) != '-') {
                integers.add(Integer.parseInt(numberString, i, i + 1, 10));
            }
        }
        return integers;
    }
}
