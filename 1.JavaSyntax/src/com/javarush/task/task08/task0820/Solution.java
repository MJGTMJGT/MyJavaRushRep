package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static class Cat{}
    public static class Dog{}
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        //напишите тут ваш код

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        result.add(cat1, cat2, cat3);
        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        return null;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> join = new HashSet<>();
        join.addAll(cats);
        join.addAll(dogs);
        return join;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        pets.addAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        pets.forEach(System.out :: println);
    }

    //напишите тут ваш код
}
