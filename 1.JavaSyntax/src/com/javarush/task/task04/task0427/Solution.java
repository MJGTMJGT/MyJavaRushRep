package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        String s2 = s1 + "";
        int len = s2.length();
        if (s1 >= 1 && s1 <= 999) {
            if (s1 % 2 == 0) {
                swch(len, "четное");
            } else {
                swch(len, "нечетное");
            }
        }
    }

    private static void swch(int a, String b) {
        switch (a) {
            case 1:
                System.out.println(b + " однозначное число");
                break;
            case 2:
                System.out.println(b + " двузначное число");
                break;
            case 3:
                System.out.println(b + " трехзначное число");
                break;
        }
    }
}
