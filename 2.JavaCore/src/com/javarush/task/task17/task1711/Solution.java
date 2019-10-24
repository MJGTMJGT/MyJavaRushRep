package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createFemale("Иванова Светлана", new Date()));  //сегодня родилась    id=2
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        allPeople.add(args[i + 1].equals("м") ? Person.createMale(args[i], df.parse(args[i + 2])) : Person.createFemale(args[i], df.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        allPeople.set(Integer.parseInt(args[i]), args[i + 2].equals("м") ? Person.createMale(args[i + 1], df.parse(args[i + 3])) : Person.createFemale(args[i + 1], df.parse(args[i + 3])));
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        if (Integer.parseInt(args[i]) >= 0 && Integer.parseInt(args[i]) < allPeople.size()) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        } else {
                            System.out.println("Элемента с индексом " + args[i] + " не существует!");
                        }
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        String s1 = allPeople.get(Integer.parseInt(args[i])).getName();
                        String s2 = allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE ? "м" : "ж";
                        String s3 = String.format(Locale.ENGLISH, "%1$td-%1$tb-%1$tY", allPeople.get(Integer.parseInt(args[i])).getBirthDate());
                        System.out.println(s1 + " " + s2 + " " + s3);
                    }
                    break;
                }
        }
    }
}
