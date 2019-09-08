package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int max = 0;
        int min = 1000;
        int imax = 0;
        int imin = 0;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++){
            list.add(reader.readLine());
            if (max < list.get(i).length()){
                max = list.get(i).length();
                imax = i;
            }
            if (min > list.get(i).length()){
                min = list.get(i).length();
                imin = i;
            }
        }
        if (imax < imin) System.out.println(list.get(imax));
        else System.out.println(list.get(imin));
        
    }
}

//        for (int i = 0; i < list.size(); i++){
//            if (list.get(i).length() != list.get(i+1).length()){
//                System.out.println(list.get(i));
//                break;
//            }
//        }

//while (min == 0 && max == 0){
//            if (list.get(i).length != list.get(i+1).length){
//                if (list.get(i).length < list.get(i+1).length) System.out.println(list.get(i).length);
//                }
//            i++
//            
//        }
//String min = 0;
//String max = 0;
//int s1 = 0;
//min = (list.get(i).length < list.get(i+1).length) ? list.get(i) : list.get(i+1);
//max = (list.get(i).length < list.get(i+1).length) ? list.get(i+1) : list.get(i);
//System.out.println(min > max ? list.get(i+1) : list.get(i+1));