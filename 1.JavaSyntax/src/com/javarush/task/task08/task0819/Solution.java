package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static class Cat {}
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        //cats.remove(cats.toArray()[0]); //удаляем одного случайного кота через массив
        Iterator<Cat> iterator = cats.iterator();
        iterator.next();
        iterator.remove();
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Cat cat = new Cat();
            set.add(cat);
        }
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        cats.forEach(System.out :: println);
    }

    // step 1 - пункт 1
}
