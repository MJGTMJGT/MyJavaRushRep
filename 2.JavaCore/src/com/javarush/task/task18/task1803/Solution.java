package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        FileInputStream fis = new FileInputStream(fileName);

        ArrayList<Integer> list = new ArrayList<Integer>();

        String str = "";

        int i, k, l = -1;

        while (fis.available() > 0) {

            i = fis.read();

            list.add(i);
        }

        fis.close();

        //System.out.println(list);

        HashSet<Integer> hashSet = new HashSet<>(list);

        //System.out.println(hashSet);

        Iterator<Integer> iHS = hashSet.iterator();

        while (iHS.hasNext()) {

            int ii = iHS.next();

            k = Collections.frequency(list, ii);

            if (k > l) l = k;

        }

        Iterator<Integer> iHS2 = hashSet.iterator();

        while (iHS2.hasNext()) {

            int ii = iHS2.next();

            k = Collections.frequency(list, ii);

            if (k == l) str += ii + " ";

        }

        System.out.println(str);
    }
}
