package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String fact = null;
        if (n < 0) {
            fact = String.valueOf(0);
        } else if (n == 0) {
            fact = String.valueOf(1);
        } else if (n <= 150) {
            BigInteger x = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) {
                x = x.multiply(BigInteger.valueOf(i));
            }
            fact = String.valueOf(x);
        }
        return fact;
    }
}
