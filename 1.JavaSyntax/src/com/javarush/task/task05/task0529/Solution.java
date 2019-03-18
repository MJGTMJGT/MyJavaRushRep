package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int s2 = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s1 = reader.readLine();
            if (s1.equals("сумма")) break;
            s2 += Integer.parseInt(s1);
        }
        System.out.println(s2);
    }
}
