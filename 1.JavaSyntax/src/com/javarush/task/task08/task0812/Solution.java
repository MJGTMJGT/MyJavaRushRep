package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        int s = list.get(0);
        int k = 1, j = 1;
        for (int i = 1; i < list.size(); i++) {
            if (s == list.get(i)) {
                k++;
                if (j < k) j = k;
            } else {
                s = list.get(i);
                k = 1;
            }
        }
        System.out.println(j);
    }
}