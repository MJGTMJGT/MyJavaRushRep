package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1, j = 1;
        while (i < 11) {
            String s = "";
            j = 1;
            while (j < 11) {
                int ii = i * j;
                s = s + " " + ii;
                j++;
            }
            System.out.println(s);
            i++;
        }
    }
}
