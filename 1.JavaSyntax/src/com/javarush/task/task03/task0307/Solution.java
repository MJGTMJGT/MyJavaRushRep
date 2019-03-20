package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        Zerg zerg6 = new Zerg();
        Zerg zerg7 = new Zerg();
        Zerg zerg8 = new Zerg();
        Zerg zerg9 = new Zerg();
        Zerg zerg10 = new Zerg();

        zerg1.name = "z1";
        zerg2.name = "z2";
        zerg3.name = "z3";
        zerg4.name = "z4";
        zerg5.name = "z5";
        zerg6.name = "z6";
        zerg7.name = "z7";
        zerg8.name = "z8";
        zerg9.name = "z9";
        zerg10.name = "z10";

        Protoss protoss1 = new Protoss();
        Protoss protoss2 = new Protoss();
        Protoss protoss3 = new Protoss();
        Protoss protoss4 = new Protoss();
        Protoss protoss5 = new Protoss();

        protoss1.name = "prot1";
        protoss2.name = "prot2";
        protoss3.name = "prot3";
        protoss4.name = "prot4";
        protoss5.name = "prot5";

        Terran terran1 = new Terran();
        Terran terran2 = new Terran();
        Terran terran3 = new Terran();
        Terran terran4 = new Terran();
        Terran terran5 = new Terran();
        Terran terran6 = new Terran();
        Terran terran7 = new Terran();
        Terran terran8 = new Terran();
        Terran terran9 = new Terran();
        Terran terran10 = new Terran();
        Terran terran11 = new Terran();
        Terran terran12 = new Terran();

        terran1.name = "ter1";
        terran2.name = "ter2";
        terran3.name = "ter3";
        terran4.name = "ter4";
        terran5.name = "ter5";
        terran6.name = "ter6";
        terran7.name = "ter7";
        terran8.name = "ter8";
        terran9.name = "ter9";
        terran10.name = "ter10";
        terran11.name = "ter11";
        terran12.name = "ter12";

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
