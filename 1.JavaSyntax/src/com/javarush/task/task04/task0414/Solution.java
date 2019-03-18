package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        /*while (true) {
            if (s1%400 == 0) {
                System.out.println("количество дней в году: 366");
                break;
            }
            if (s1%100 == 0) {
                System.out.println("количество дней в году: 365");
                break;
            }
            if (s1%4 == 0) {
                System.out.println("количество дней в году: 366");
                break;
            }
            else {
                System.out.println("количество дней в году: 365");
                break;
            }
        }*/
        if (s1%400 == 0) {
            System.out.println("количество дней в году: 366");
        }
        else if (s1%100 == 0) {
            System.out.println("количество дней в году: 365");
        }
        else if (s1%4 == 0) {
            System.out.println("количество дней в году: 366");
        }
        else {
            System.out.println("количество дней в году: 365");
        }
    }
}