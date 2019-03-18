package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int intx = Integer.parseInt(reader.readLine());
        int i = intx;
        while (true) {
            if (i == 0) {
                break;
            }
            System.out.println(string);
            i--;
        }

    }
}
