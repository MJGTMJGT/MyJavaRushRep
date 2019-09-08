package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[5];
            int a = 0;
            for (int i = 0; i <= arr.length; i++) {
                a += arr[i];
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i = Integer.parseInt("s1");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new EmptyStackException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
