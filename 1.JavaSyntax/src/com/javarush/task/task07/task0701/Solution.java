package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array1 = new int[20];
        for(int i = 0; i < array1.length; i++){
            array1[i] = Integer.parseInt(reader.readLine());
        }
        return array1;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int maxim = array[0];
        for(int i = 1; i < array.length; i++){
            if (array[i] > maxim){
                maxim = array[i];
            }
        }
        return maxim;
    }
}
