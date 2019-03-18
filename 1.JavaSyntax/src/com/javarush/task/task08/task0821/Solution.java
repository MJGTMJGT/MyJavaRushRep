package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Иванова", "Татьяна");
        hashMap.put("Петрова", "Елена");
        hashMap.put("Сидорова", "Татьяна");
        hashMap.put("Иванова", "Лариса");
        hashMap.put("Кукуева", "Елизавета");
        hashMap.put("Семёнова", "Елизавета");
        hashMap.put("Борисова", "Елизавета");
        hashMap.put("Удальцова", "Елена");
        hashMap.put("Петрова", "Елизавета");
        hashMap.put("Путина", "Елена");
        return hashMap;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
