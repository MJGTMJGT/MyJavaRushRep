package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date d = dateFormat.parse(date);
        Date dStart = dateFormat.parse(date);
        dStart.setDate(1);
        dStart.setMonth(0);
        long msTimeDist = d.getTime() - dStart.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msTimeDist / msDay);
        return dayCount % 2 == 0;
        //Ниже отличное решение, увы нагуглил позже)
        /*Date dateD = new Date(date); //создание нового объекта даты на основе String data
        SimpleDateFormat sdf = new SimpleDateFormat("D");//задаётся формат для даты, "D"-номер дня в году
        return Integer.parseInt(sdf.format(dateD)) % 2 != 0;      //применяем формат к  дате, и преобразуем к типу int проверка на нечётность и возвращение значения типа boolean*/
    }
}
