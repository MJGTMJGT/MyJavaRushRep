package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "C:\\1.txt";
        FileInputStream fis = new FileInputStream(fileName);
        int i, j = 0;
        //while ((i = fis.read()) != -1) if ((char)i == ',') j++;
        while (fis.available() > 0) if ((char)fis.read() == ',') j++;
        fis.close();
        System.out.println(j);
    }
}
