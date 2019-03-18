package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            list0.add(i,Integer.parseInt(reader.readLine()));
        }
        int k1 = 0, k2 = 0, k3 = 0;
        for (int i = 0; i < list0.size(); i++) {
            if (list0.get(i) % 3 != 0 && list0.get(i) % 2 != 0) {
                list3.add(k3, list0.get(i));
                k3++;
            } else {
                if (list0.get(i) % 3 == 0) {
                    list1.add(k1, list0.get(i));
                    k1++;
                    if (list0.get(i) % 2 == 0) {
                        list2.add(k2, list0.get(i));
                        k2++;
                    }
                } else {
                    list2.add(k2, list0.get(i));
                    k2++;
                }
            }
        }
        printList(list1);
        printList(list2);
        printList(list3);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        list.forEach(s -> System.out.println(s));
    }
}
