package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 0;
        strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++){
            strings.add(reader.readLine());
        }
        
        int min = strings.get(0).length();
        //String s1 = strings.get(0);
        
        for (int i = 1; i < strings.size(); i++){
            if (strings.get(i).length() > min) min = strings.get(i).length();
        }
        
        for (int i = 0; i < strings.size(); i++){
            if (strings.get(i).length() == min) System.out.println(strings.get(i));
        }
        //s1 = min > strings.get(i).length() ? strings.get(i) : s1;
        
    }
}
