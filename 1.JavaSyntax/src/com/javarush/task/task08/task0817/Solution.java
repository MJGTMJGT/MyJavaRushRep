package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (Map.Entry entry: map.entrySet()) {
            for (String tmp : map.values()) if (String.valueOf(entry.getValue()).equals(tmp)) count++;
            if (count > 1) list.add(String.valueOf(entry.getValue()));
            count = 0;
        }
        for (int i = 0; i < list.size(); i++) removeItemFromMapByValue(map, String.valueOf(list.get(i)));
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        //removeTheFirstNameDuplicates(createMap());
    }
}
