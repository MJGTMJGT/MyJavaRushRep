package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Иванова", "Татьяна");
        hashMap.put("Петрова", "Елена");
        hashMap.put("Сидорова", "Татьяна");
        hashMap.put("Иванцова", "Лариса");
        hashMap.put("Кукуева", "Елизавета");
        hashMap.put("Семёнова", "Елизавета");
        hashMap.put("Борисова", "Елизавета");
        hashMap.put("Удальцова", "Елена");
        hashMap.put("Петрушкина", "Елизавета");
        hashMap.put("Путина", "Елена");
        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String tmp : map.values()) if (name.equals(tmp)) count++;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String tmp : map.keySet()) if (lastName.equals(tmp)) count++;
        return count;
    }

    public static void main(String[] args) {

    }
}
