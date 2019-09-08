package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.1, "dsc");
        labels.put(8.9, "hdsacbj");
        labels.put(9.0, "jhcbs");
        labels.put(6.1, "ouiach");
        labels.put(4.4, "wqiue");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
