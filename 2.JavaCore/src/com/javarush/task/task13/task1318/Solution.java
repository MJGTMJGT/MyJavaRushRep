package com.javarush.task.task13.task1318;

import javax.print.attribute.standard.Sides;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        reader.close();

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        String s2 = "";

        try {
            inputStream = new FileInputStream(s1);
            bufferedInputStream = new BufferedInputStream(inputStream);
            while (bufferedInputStream.available() > 0) {
                char c = (char) bufferedInputStream.read();
                s2 += c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(inputStream).close();
            Objects.requireNonNull(bufferedInputStream).close();
        }

        System.out.println(s2);

        // Можно было и так))
        /*InputStream is = new FileInputStream(s1);
        while (is.available() > 0) {
            System.out.write(is.read());
        }
        System.out.println();
        is.close();*/
    }
}