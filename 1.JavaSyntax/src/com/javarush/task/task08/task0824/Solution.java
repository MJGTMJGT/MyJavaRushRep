package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Iya", false, 34);
        Human child2 = new Human("Kat", false, 34);
        Human child3 = new Human("Oleg", true, 37);
        /*Human father = new Human("John", true, 37, new ArrayList<>(Arrays.asList(child1, child2, child3)));
        Human mather = new Human("Liza", false, 34, new ArrayList<>(Arrays.asList(child1, child2, child3)));
        Human grandFather1 = new Human("Alex", true, 65, new ArrayList<>(Collections.singletonList(father)));
        Human grandFather2 = new Human("Petr", true, 61, new ArrayList<>(Collections.singletonList(mather)));
        Human grandMather1 = new Human("Alla", false, 60, new ArrayList<>(Collections.singletonList(father)));
        Human grandMather2 = new Human("Svetlana", false, 64, new ArrayList<>(Collections.singletonList(mather)));*/
        Human father = new Human("John", true, 37, child1, child2, child3);
        Human mather = new Human("Liza", false, 34, child1, child2, child3);
        Human grandFather1 = new Human("Alex", true, 65, father);
        Human grandFather2 = new Human("Petr", true, 61, mather);
        Human grandMather1 = new Human("Alla", false, 60, father);
        Human grandMather2 = new Human("Svetlana", false, 64, mather);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMather1);
        System.out.println(grandMather2);
        System.out.println(father);
        System.out.println(mather);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        /*public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }*/

        public Human(String name, boolean sex, int age, Human ... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.addAll(Arrays.asList(children));
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
