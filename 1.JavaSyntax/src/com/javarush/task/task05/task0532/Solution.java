package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int[] arr = new int[s1];
        for (int i = 0; i < s1; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        //напишите тут ваш код
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) maximum = Math.max(maximum, arr[i]);

        System.out.println(maximum);
    }
}
