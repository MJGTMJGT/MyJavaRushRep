package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(41);
        hashSet.add(7);
        hashSet.add(15);
        hashSet.add(4);
        hashSet.add(1);
        hashSet.add(90);
        hashSet.add(9);
        hashSet.add(16);
        hashSet.add(24);
        hashSet.add(8);
        hashSet.add(32);
        hashSet.add(54);
        hashSet.add(6);
        hashSet.add(25);
        hashSet.add(2);
        hashSet.add(19);
        hashSet.add(3);
        hashSet.add(78);
        hashSet.add(83);
        hashSet.add(64);
        /*for (int i = 0; i < 20; i++) {
            int s = (int) (Math.random() * 25);
            hashSet.add(s);
        }*/
        return hashSet;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        // напишите тут ваш код
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer elem = iterator.next();
            if (elem > 10) iterator.remove();
        }
        //set.removeIf(element -> element > 10);
        System.out.println(set);
        return set;
    }

    public static void main(String[] args) {

    }
}
