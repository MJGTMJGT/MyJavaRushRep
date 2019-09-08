package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] list1 = new int[20];
        //ArrayList<Integer> list = ArrayList<Integer>();
        for (int i = 0; i < 20; i++){
            list1[i] = Integer.parseInt(reader.readLine());
            //list.add(list1(i));
        }
        Arrays.sort(list1);
        maximum = list1[list1.length-1];
        minimum = list1[0];

        System.out.print(maximum + " " + minimum);
    }
}
