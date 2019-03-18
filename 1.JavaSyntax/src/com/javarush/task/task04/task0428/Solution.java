package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        int arr[] = {s1, s2, s3};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
