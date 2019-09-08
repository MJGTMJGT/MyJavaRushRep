package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Double d;
        short sh;
        Integer i;
        while (!(s = reader.readLine()).equals("exit")) {
            try {
                if (s.contains(".")) {
                    print(Double.parseDouble(s));
                } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                    sh = Short.parseShort(s);
                    print(sh);
                } else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) {
                    i = Integer.parseInt(s);
                    print(i);
                } else print(s);
            } catch (Exception e) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
