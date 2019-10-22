package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        //Thread thread = new Thread(new myClass1());
        threads.add(new Thread(new myClass1()));
        threads.add(new Thread(new myClass2()));
        threads.add(new Thread(new myClass3()));
        threads.add(new myClass4());
        threads.add(new Thread(new myClass5()));
    }

    public static void main(String[] args) {
    }
}

class myClass1 implements Runnable {

    @Override
    public void run() {
        //Thread.sleep(1000000);
        while (true){}
    }
}

class myClass2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("InterruptedException");
        }
    }
}

class myClass3 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class myClass4 extends Thread implements Message {

    @Override
    public void run() {
        while (!isInterrupted()) {}
    }

    @Override
    public void showWarning() {
        interrupt();
    }
}

class myClass5 implements Runnable {
    private String s1;
    private long l1 = 0;

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(s1 = reader.readLine()).equals("N")) l1 += Integer.parseInt(s1);
            System.out.println(l1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}