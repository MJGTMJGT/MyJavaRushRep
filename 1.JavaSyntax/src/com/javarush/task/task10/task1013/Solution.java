package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private boolean sex;
        private int age;
        private int weight;
        private int growth;

        public Human(String name, String lastName, boolean sex, int age, int weight, int growth) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(String name, String lastName, boolean sex, int age, int weight) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, String lastName, boolean sex, int age) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String lastName, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String lastName, boolean sex, int age, int weight, int growth) {
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(boolean sex, int age, int weight, int growth) {
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(int age, int weight, int growth) {
            this.age = age;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(int weight, int growth) {
            this.weight = weight;
            this.growth = growth;
        }
    }
}
