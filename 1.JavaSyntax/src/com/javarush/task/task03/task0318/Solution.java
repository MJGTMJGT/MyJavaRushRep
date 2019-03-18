package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s2 = Integer.parseInt(reader.readLine());
        String s1 = reader.readLine();
        //int s2 = reader.read();

        System.out.println(s1 + " захватит мир через " + s2 + " лет. Му-ха-ха!");
    }
}
