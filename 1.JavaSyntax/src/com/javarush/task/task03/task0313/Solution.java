package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    /*String a, b, c;*/
    public static void main(String[] args) {
        String a = new String("Мама");
        String b = new String("Мыла");
        String c = new String("Раму");
        //напишите тут ваш код
        /*a = "Мама";
        b = "Мыла";
        c = "Раму";*/
        System.out.println(a+b+c);
        System.out.println(a+c+b);
        System.out.println(b+c+a);
        System.out.println(b+a+c);
        System.out.println(c+b+a);
        System.out.print(c+a+b);
    }
}
