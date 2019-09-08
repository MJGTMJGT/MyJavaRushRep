package com.javarush.task.task02.task0217;

/* 
Минимум четырех чисел
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
        //напишите тут ваш код
        int[] arr = new int[]{a, b, c, d};
        int x = a;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < x) {
                x = arr[i];
            }
        }
        return x;
    }

    public static int min(int a, int b) {
        //напишите тут ваш код
        int x = 0;
        if (a < b) {
            x = a;
        } else {
            x = b;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}