package com.javarush.task.task04.task0436;
import java.util.Scanner;

/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner in1 = new Scanner(System.in);
        int m = in1.nextInt();
        Scanner in2 = new Scanner(System.in);
        int n = in2.nextInt();
        for (int i = 1; i <=m; i++){
            for (int j = 1; j <=n; j++){
                System.out.print(8);
            }
            System.out.print("\n");
        }

    }
}
