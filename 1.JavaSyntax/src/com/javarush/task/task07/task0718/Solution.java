package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++){
            list.add(reader.readLine());
        }
        
        int maxLength = list.get(0).length();
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).length() < maxLength){
                System.out.println(i);
                break;
            } else maxLength = list.get(i).length();
        }
    }
}

//Решил в 1 попытку за пару минут, комменты удивляют.
//1. Создаем переменную maxLength, в которой будем хранить максимальную длину 
//строки, инициализируем длиной строки первого элемента списка.
//2.Обходим список через for по индексам, если встретили элемент, длина которого 
//меньше maxLength - печатаем индекс и брейк. Иначе присваиваем maxLength длину 
//текущего элемента списка. reader