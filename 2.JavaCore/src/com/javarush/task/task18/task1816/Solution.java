package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        //FileInputStream fis = new FileInputStream("C:\\1.txt");
        long count = 0;
        //Этот способ намного быстрее
        /*while (fis.available() > 0) {
            int i = fis.read();
            if (i > 64 && i < 91 || i > 96 && i < 123) count++;
        }*/
        while (fis.available() > 0) {
            String s = String.valueOf((char) fis.read());
            if (s.matches("^[a-zA-Z]$")) count++;
        }
        fis.close();
        System.out.println(count);
    }
}
