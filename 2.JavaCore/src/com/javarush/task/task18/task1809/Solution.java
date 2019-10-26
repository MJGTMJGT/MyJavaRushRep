package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

//Использовал Stack

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        /*String fileName1 = "C:\\1.txt";
        String fileName2 = "C:\\2.txt";*/
        reader.close();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);
        Stack<Integer> stack = new Stack<>();
        while (fis.available() > 0) stack.push(fis.read());
        while (!stack.isEmpty()) fos.write(stack.pop());
        fis.close();
        fos.close();
    }
}
