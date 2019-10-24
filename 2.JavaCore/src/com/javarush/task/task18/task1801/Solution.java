package com.javarush.task.task18.task1801;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        int i, max = Integer.MIN_VALUE;
        while ((i = fis.read()) != -1) if (i > max) max = i;
        System.out.println(max);
        fis.close();
    }
}

//Можно и так
/*while (fis.available() > 0){
    i = fis.read();
    if (i > max) max = i;
}*/
