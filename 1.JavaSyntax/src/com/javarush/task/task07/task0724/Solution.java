package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandfather1 = new Human("Александр", true, 59);
        Human grandfather2 = new Human("Виталий", true, 54);
        Human grandmather1 = new Human("Елена", false, 53);
        Human grandmather2 = new Human("Татьяна", false, 58);
        Human father = new Human("Евгений", true, 34, grandfather1, grandmather1);
        Human mather = new Human("Елизавета", false, 30, grandfather2, grandmather2);
        Human child1 = new Human("Вероника", false, 3, father, mather);
        Human child2 = new Human("Алексей", true, 2, father, mather);
        Human child3 = new Human("Сергей", true, 1, father, mather);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmather1);
        System.out.println(grandmather2);
        System.out.println(father);
        System.out.println(mather);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}