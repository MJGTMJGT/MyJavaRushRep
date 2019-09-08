package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] listInt = new int[20];
        int[] listInt1 = new int[10];
        int[] listInt2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < listInt.length; i++){
            listInt[i] = Integer.parseInt(reader.readLine());
            if (i < 10) listInt1[i] = listInt[i];
            else {
                listInt2[i-10] = listInt[i];
                System.out.println(listInt2[i-10]);
            }
        }
    }
}
