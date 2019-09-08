package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return (a + b);
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return (a - b);
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double s1 = a*1.0/b*1.0;
        return s1;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double s2 = (a*b*1.0)/100;
        return s2;
    }

    public static void main(String[] args) {

    }
}