package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float s2 = 0, srarf = 0.0f;
        int i = 0;
        while (true) {
            int s1 = Integer.parseInt(reader.readLine());
            if (s1 == -1) {
                if (i == 0) {
                    break;
                } else {
                    srarf = s2 / i;
                    System.out.println(srarf);
                    break;
                }
            }
            i++;
            s2 += s1;
        }
    }
}

