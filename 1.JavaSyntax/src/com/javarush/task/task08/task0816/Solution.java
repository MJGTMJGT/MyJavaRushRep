package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        //напишите тут ваш код
        //map.put("Stallone", df.parse("JULY 6 1946"));
        map.put("Schwarzenegger", df.parse("JULY 30 1947"));
        map.put("Lundgren", df.parse("NOVEMBER 3 1957"));
        map.put("Statham", df.parse("JULY 26 1967"));
        map.put("Willis", df.parse("MARCH 19 1955"));
        map.put("Gibson", df.parse("JANUARY 3 1956"));
        map.put("Cruise", df.parse("JULY 3 1962"));
        map.put("Chan", df.parse("APRIL 7 1954"));
        map.put("Norris", df.parse("MARCH 10 1940"));
        map.put("Ford", df.parse("JULY 13 1942"));
        //System.out.println(map);
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        //первое решение через лямбды
        //map.entrySet().removeIf(entry->entry.getValue().getMonth()>4&&entry.getValue().getMonth()<8);
        //второе решение через копию мапы + foreach
        HashMap<String, Date> copy = new HashMap<String, Date>(map);
        for (Map.Entry<String, Date> pair : copy.entrySet()) {
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8) map.remove(pair.getKey());
        }
        //третье решение через итератор
        /*Iterator<HashMap.Entry<String,Date>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry<String,Date> element = iter.next();
            Date d = element.getValue();
            if (d.getMonth()>4&&d.getMonth()<8) {
                iter.remove();
            }
        }*/
        //System.out.println(map);
    }

    public static void main(String[] args) throws ParseException {
        //removeAllSummerPeople(createMap());
    }
}
