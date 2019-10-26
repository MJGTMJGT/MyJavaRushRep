package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream isr;
        String fileName;
        do {
            fileName = reader.readLine();
            isr = new FileInputStream(fileName);
        } while (isr.available() >= 1000);
        reader.close();
        isr.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
