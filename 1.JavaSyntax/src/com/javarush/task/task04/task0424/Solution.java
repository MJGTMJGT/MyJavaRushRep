package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        if (s1 == s2 && s1 != s3) {
            System.out.println("3");
        }
        if (s2 != s1 && s2 == s3) {
            System.out.println("1");
        }
        if (s3 != s2 && s3 == s1) {
            System.out.println("2");
        }
    }
}
