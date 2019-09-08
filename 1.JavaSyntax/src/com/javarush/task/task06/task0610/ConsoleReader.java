package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader1.readLine();
        return s1;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        int s2 = Integer.parseInt(reader2.readLine());
        return s2;

    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        double s3 = Double.parseDouble(reader3.readLine());
        return s3;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
        boolean s4 = Boolean.parseBoolean(reader4.readLine());
        return s4;

    }

    public static void main(String[] args) {

    }
}
