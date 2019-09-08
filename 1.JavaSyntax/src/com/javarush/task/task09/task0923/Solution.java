package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> listVowel = new ArrayList<>(), listOther = new ArrayList<>();
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

        for (Character cha : s.toCharArray()) {
            if (cha != ' ') {
                if (isVowel(cha)) listVowel.add(cha + " ");
                else listOther.add(cha + " ");
            }
        }
        listVowel.forEach(System.out::print);
        System.out.println();
        listOther.forEach(System.out::print);
        //Элегантное решение из комментов)
        /*String s = new BufferedReader(new InputStreamReader(System.in)).readLine().replace(" ", "");
        String a = "", b = "";
        for (Character ch : s.toCharArray()) {
            if (isVowel(ch)) a += ch + " ";
            else b += ch + " ";
        }
        System.out.println(a);
        System.out.println(b);*/
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}