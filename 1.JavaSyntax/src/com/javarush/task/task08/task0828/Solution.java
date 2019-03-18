package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Способ 1
        /*HashMap<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December",12 );
        String userInput = reader.readLine();
        System.out.println(userInput + " is the " + map.get(userInput) + " month");*/
        //Способ 2
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(reader.readLine());
        DateFormat dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        int s = dateFormat.parse(arrayList.get(0)).getMonth() + 1;
        System.out.println(arrayList.get(0) + " is the " + s + " month");
    }
}
