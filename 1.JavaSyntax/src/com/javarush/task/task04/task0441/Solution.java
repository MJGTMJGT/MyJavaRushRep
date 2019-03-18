package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        int ss = 0;
        if ((s1 < s2 && s1 > s3) || (s1 > s2 && s1 < s3)) {
            ss = s1;
        } else {
            if ((s2 < s1 && s2 > s3) || (s2 > s1 && s2 < s3)) {
                ss = s2;
            } else {
                if ((s3 < s1 && s3 > s2) || (s3 > s1 && s3 < s2)) {
                    ss = s3;
                } else {
                    if (s1 == s2) {
                        ss = s1;
                    }
                    if (s2 == s3) {
                        ss = s2;
                    }
                    if (s3 == s1) {
                        ss = s3;
                    }

                }
            }
        }
        System.out.println(ss);
    }
}
