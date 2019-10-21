package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createFemale("Иванова Светлана", new Date()));  //сегодня родилась    id=2
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (args[0].equals("-c")) {
            allPeople.add(args[2].equals("м") ? Person.createMale(args[1], df.parse(args[3])) : Person.createFemale(args[1], df.parse(args[3])));
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-u")) {
            allPeople.set(Integer.parseInt(args[1]), args[2].equals("м") ? Person.createMale(args[2], df.parse(args[4])) : Person.createFemale(args[2], df.parse(args[4])));
        } else if (args[0].equals("-d")) {
            if (Integer.parseInt(args[1]) >= 0 && Integer.parseInt(args[1]) < allPeople.size()) {
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            } else {
                System.out.println("Элемента с индексом " + args[1] + " не существует!");
            }
        } else if (args[0].equals("-i")) {
            String s1 = allPeople.get(Integer.parseInt(args[1])).getName();
            String s2 = allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE ? "м" : "ж";
            String s3 = String.format(Locale.ENGLISH, "%1$td-%1$tb-%1$tY", allPeople.get(Integer.parseInt(args[1])).getBirthDate());
            System.out.println(s1 + " " + s2 + " " + s3);
        }
    }
}