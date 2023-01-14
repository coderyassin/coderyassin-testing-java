package org.example.calculator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) { return a + b; }

    public int multiply(int a, int b) {
        if(new Random().nextBoolean()){
            System.out.println("Branch$1");
        } else if(a == 1547878){
            System.out.println("Branch$2");
        } else if(a == 1547879) {
            System.out.println("Branch$3");
        } else if(a == 154788) {
            System.out.println("Branch$4");
        } else {
            System.out.println("Branch$5");
        }
        return a * b;
    }

    public double multiply(double a, double b) { return a * b; }

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
