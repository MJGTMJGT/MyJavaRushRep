package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut1 = reader.readLine();
        String fileNameOut2 = reader.readLine();
        /*String fileNameIn = "C:\\1.txt";
        String fileNameOut1 = "C:\\2.txt";
        String fileNameOut2 = "C:\\3.txt";*/
        FileInputStream fis = new FileInputStream(fileNameIn);
        reader.close();
        int j, k = 0, l;
        j = fis.available();
        System.out.println(j);
        l = j % 2 == 0 ? j / 2 : (j) / 2 + 1;
        FileOutputStream fos1 = new FileOutputStream(fileNameOut1);
        FileOutputStream fos2 = new FileOutputStream(fileNameOut2);
        while (fis.available() > 0) {
            if (k < l) {
                fos1.write(fis.read());
                k++;
            } else fos2.write(fis.read());
        }
        System.out.println(k);
        fis.close();
        fos1.close();
        fos2.close();
    }
}
