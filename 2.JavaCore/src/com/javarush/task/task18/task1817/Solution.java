package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        //FileInputStream fis = new FileInputStream("C:\\1.txt");
        long i = 0, allSImb = fis.available();
        while (fis.available() > 0) {
            if (fis.read() == 32) i++;
        }
        fis.close();
        float k = (float) i / allSImb * 100;
        System.out.println(String.format("%.2f", k));
    }
}
