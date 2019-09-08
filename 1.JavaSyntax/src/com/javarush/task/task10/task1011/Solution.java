package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        //массив чаров (массив символов) из строки
        char[] chars = s.toCharArray();
        for (int i = 0; i < 40; i++) {
            String s1 = "";
            for (int j = i; j < chars.length; j++) {
                s1 += chars[j];
            }
            System.out.println(s1);
        }
    }

}

