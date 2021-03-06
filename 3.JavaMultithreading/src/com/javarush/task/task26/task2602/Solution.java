package com.javarush.task.task26.task2602;

import java.util.Set;
import java.util.TreeSet;

/* 
Был бы ум - будет и успех
*/

public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }


        @Override
        public int compareTo(Soldier o) {
//            if(this.height > o.height) return 1;else
//                if(this.height <o.height) return 1; else return 0;
            return this.height > o.height ?  -1 : this.height == o.height ? 0 : 1;
        }


    }

}
