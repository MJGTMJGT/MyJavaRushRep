package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        /*int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        int h = 8;
        int i = 9;
        int j = 10;
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j);
        System.out.println(b + " " );
        System.out.println(c + " ");
        System.out.println(d + " ");
        System.out.println(e + " ");
        System.out.println(f + " ");
        System.out.println(g + " ");
        System.out.println(h + " ");
        System.out.println(i + " ");
        System.out.println(j + " ");*/

        for (int x = 1; x <=10; x++){
            for (int y = 1; y<=10; y++){
                int z = x*y;
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }
}
