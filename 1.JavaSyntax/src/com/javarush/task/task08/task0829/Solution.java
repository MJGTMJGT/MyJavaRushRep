package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        //List<String> addresses = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            hashMap.put(city, family);
            //addresses.add(family);
        }

        // Read the house number
        //int houseNumber = Integer.parseInt(reader.readLine());
        String searchCity = reader.readLine();
        System.out.println(hashMap.get(searchCity));
        /*if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familyName = addresses.get(houseNumber);
            System.out.println(familyName);
        }*/
    }
}
