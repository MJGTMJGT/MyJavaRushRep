package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] listStr = new String[10];
        int[] listInt = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < listStr.length; i++){
            listStr[i] = reader.readLine();
            listInt[i] = listStr[i].length();
            System.out.println(listInt[i]);
        }
    }
}
