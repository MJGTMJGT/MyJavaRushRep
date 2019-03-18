package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        int s11=0, s12=0, s13=0;
        if (s1 >= s2 && s1 >= s3) {
            s11 = s1;
            if (s2 >= s3) {
                s12 = s2;
                s13 = s3;
            } else {
                s12 = s3;
                s13 = s2;
            }
        } else {
            if (s2 >= s1 && s2 >= s3) {
                s11 = s2;
                if (s1 >= s3) {
                    s12 = s1;
                    s13 = s3;
                } else {
                    s12 = s3;
                    s13 = s1;
                }
            } else {
                s11 = s3;
                if (s1 >= s2) {
                    s12 = s1;
                    s13 = s2;
                } else {
                    s12 = s2;
                    s13 = s1;
                }
            }
        }
        System.out.println(s11 + " " + s12 + " " + s13);
    }
}
