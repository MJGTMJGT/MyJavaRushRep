package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        reader.close();

        ArrayList<Integer> arr = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(s1);
            int i;
            String s2 = "";
            while ((i = fis.read()) != -1) {
                if ((char) i == '\n') {
                    arr.add(Integer.valueOf(s2));
                    s2 = "";
                } else {
                    s2 += (char) i;
                }
            }
            if (!s2.equals("") && !s2.equals("\n")) {
                arr.add(Integer.valueOf(s2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Objects.requireNonNull(fis).close();
        }

        Collections.sort(arr);
        for (int ii : arr) {
            if (ii % 2 == 0) {
                System.out.println(ii);
            }
        }
    }
}
