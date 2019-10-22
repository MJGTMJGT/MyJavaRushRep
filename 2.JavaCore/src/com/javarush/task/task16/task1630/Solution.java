package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String str = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            //return new String(Files.readAllBytes(Paths.get(fileName)));
            return this.str;
        }

        @Override
        public void run() {
            try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                String s1;
                while ((s1 = reader2.readLine()) != null) str += s1 + " ";
                getFileContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
