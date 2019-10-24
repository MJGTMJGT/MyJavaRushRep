package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(fileName);
        String str = "";
        int k, l = Integer.MAX_VALUE;
        while (fis.available() > 0) list.add(fis.read());
        //System.out.println(list);
        fis.close();
        HashSet<Integer> hashSet = new HashSet<>(list);
        //System.out.println(hashSet);
        Iterator<Integer> iHS1 = hashSet.iterator();
        while (iHS1.hasNext()) {
            k = Collections.frequency(list, iHS1.next());
            if (k < l) l = k;
        }
        Iterator<Integer> iHS2 = hashSet.iterator();
        while (iHS2.hasNext()) {
            int i = iHS2.next();
            k = Collections.frequency(list, i);
            if (k == l) str += i + " ";
        }
        System.out.println(str);
    }
}
