package com.javarush.task.task06.task0606;

import sun.security.util.Length;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int numCreat;
        if (s1 < 0) s1 *= -1;
        for (; s1 > 0; s1 /= 10) {
            numCreat = s1 % 10;
            /*int x = Integer.parseInt(s1.substring(i, i++));*/
            if (numCreat % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
