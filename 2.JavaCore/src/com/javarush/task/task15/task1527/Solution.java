package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        //String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        //char[] chars = s.toCharArray();
        //String s1 = s.substring(s.indexOf("?") + 1);
        //String urlParse = (String) url.subSequence(url.indexOf("?") + 1, url.lastIndexOf("="));
        //String urlParseChange = urlParse.replace('=', '&');
        String urlParse = url.substring(url.indexOf("?") + 1);
        String[] param = urlParse.split("&");
        String s = null;
        for (String str : param) {
            if (str.contains("=")) System.out.print(str.substring(0, str.indexOf("=")) + " ");
            else System.out.print(str + " ");
            if (str.contains("obj")) s = str.substring(str.indexOf("=") + 1);
        }
        System.out.println();
        if (s != null) {
            try {
                alert(Double.parseDouble(s));
            } catch (Exception e) {
                alert(s);
            }
        }
        /*if (param[0].equals("lvl")) {
            System.out.println(param[0] + " " + param[2] + " " + param[3]);
        } else if (param[0].equals("obj")) {
            System.out.println("obj name");
            try {
                alert(Double.parseDouble(param[1]));
            } catch (Exception e) {
                alert(param[1]);
            }
        }*/
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}