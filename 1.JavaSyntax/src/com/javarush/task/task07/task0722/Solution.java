package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        //напишите тут ваш код
        while (true) {
            String s1 = reader.readLine();
            if (s1.equals("end")) {
                break;
            } else {
                list.add(s1);
            }
        }
        //list.forEach(s -> System.out.println(s));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}