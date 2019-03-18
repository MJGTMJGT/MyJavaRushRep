package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        int s4 = Integer.parseInt(reader.readLine());
        if (s1 >= s2 && s1 >= s3 && s1 >= s4) {
            System.out.println(s1);
        } else {
            if (s2 >= s1 && s2 >= s3 && s2 >= s4) {
                System.out.println(s2);
            } else {
                if (s3 >= s2 && s3 >= s1 && s3 >= s4) {
                    System.out.println(s3);
                } else {
                    System.out.println(s4);
                }
            }
        }
    }
}
