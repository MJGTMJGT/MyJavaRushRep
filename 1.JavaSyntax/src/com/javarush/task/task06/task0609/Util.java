package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        int a = x1-x2;
        int b = y1-y2;
        if (a<0) a*=-1;
        if (b<0) b*=-1;
        return Math.sqrt(a*a + b*b);
    }

    public static void main(String[] args) {

    }
}
