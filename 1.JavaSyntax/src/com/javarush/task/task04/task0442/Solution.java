package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = true;
        int summ = -1;
        while (isExit) {
            int s1 = Integer.parseInt(reader.readLine());
            if (s1 == -1) {
                System.out.println(summ);
                break;
            } else {
                summ += s1;
            }
        }
    }
}
