package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Objects;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s2 = "";

        String s1 = reader.readLine();

        while (true) {
            String s3 = reader.readLine();
            if (s3.equals("exit")) {
                s2 += s3;
                break;
            } else {
                s2 += s3 + "\n";
            }
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(s1);
            bw = new BufferedWriter(fw);
            bw.write(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(bw).close();
        fw.close();
    }
}
