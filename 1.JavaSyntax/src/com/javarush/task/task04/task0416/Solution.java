package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double s1 = Double.parseDouble(reader.readLine());
        double y = s1 % 5;
        if (y >= 0 && y < 3) {
            System.out.println("зелёный");
        }
        if (y >= 3 && y < 4) {
            System.out.println("жёлтый");
        }
        if (y >= 4 && y < 5) {
            System.out.println("красный");
        }
    }
}