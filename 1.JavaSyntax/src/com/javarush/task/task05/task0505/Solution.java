package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat1 = new Cat("Vaska", 2, 1, 6);
        Cat cat2 = new Cat("Barsik", 3, 2, 4);
        Cat cat3 = new Cat("Murzik", 1, 2, 7);

        if (cat1.fight(cat2) == true) {
            System.out.println("Cat1 Win!!!");
        } else {
            System.out.println("Cat2 Win!!!");
        }

        if (cat2.fight(cat3) == true) {
            System.out.println("Cat2 Win!!!");
        } else {
            System.out.println("Cat3 Win!!!");
        }

        if (cat3.fight(cat1) == true) {
            System.out.println("Cat3 Win!!!");
        } else {
            System.out.println("Cat1 Win!!!");
        }
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
