package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        HashSet<Integer> hashSet = new HashSet<>();
        while (fis.available() > 0) hashSet.add(fis.read());
        fis.close();
        //System.out.println(hashSet);
        ArrayList<Integer> list = new ArrayList<>(hashSet);
        //System.out.println(list);
        Collections.sort(list);
        String str = "";
        for (Integer i : list) str += i + " ";
        System.out.println(str);
    }
}
