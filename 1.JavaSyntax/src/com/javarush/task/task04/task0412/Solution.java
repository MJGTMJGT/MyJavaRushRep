package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        if (s1 >= 0) {
            s1 *= 2;
        } else {
            s1++;
        }
        System.out.println(s1);
    }

}