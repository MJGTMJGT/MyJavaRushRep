package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

public class Solution {
    public static void main(String[] args) throws Exception {
        long i1, i2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        i1 = Long.parseLong(reader.readLine());
        i2 = Long.parseLong(reader.readLine());
        if (i1 <= 0 || i2 <= 0) throw new Exception();
        long i = Math.min(i1, i2);
        while (true) {
            if (i1 % i == 0 && i2 % i == 0) {
                System.out.println(i);
                break;
            }
            i--;
        }
    }
}
