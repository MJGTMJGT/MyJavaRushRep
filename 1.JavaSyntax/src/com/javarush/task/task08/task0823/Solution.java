package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //напишите тут ваш код
        //хорошее решение, но не для этой задачи!
        /*String[] words = s.split(" ");
        s = "";
        for (String w : words) s += w.substring(0, 1).toUpperCase() + w.substring(1) + " ";
        System.out.println(s.trim());*/

        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++) if(i==0 || sb.charAt(i-1) == ' ') sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        System.out.println(sb.toString());
    }
}
