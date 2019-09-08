package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (true) {
            int id;
            try {
                id = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                break;
            }
            String name = reader.readLine();
            if (name.equals("") == true) {
                hashMap.put(name, id);
                break;
            }
            hashMap.put(name, id);
        }
        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
        //System.out.println("Id=" + id + " Name=" + name);
    }
}
