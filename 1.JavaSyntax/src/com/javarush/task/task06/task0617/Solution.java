package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    //напишите тут ваш код
    public static class Idea
    {
        public String getDescription()
        {
            return "Hi";
        }
    }
    
    public static void printIdea(Idea idea){
        String s1 = idea.getDescription();
        System.out.println(s1);
    }
}
