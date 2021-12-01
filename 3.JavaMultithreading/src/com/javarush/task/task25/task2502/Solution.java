package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT


    }

    public static class Car {
        protected List<Wheel> wheels;




        public Car() {
            List<Wheel> w = new ArrayList<Wheel>();
           String [] str = loadWheelNamesFromDB();
           Wheel [] whe = Wheel.values();
           if(str.length!=4)  throw new NullPointerException();
            for (int i = 0; i < str.length; i++) {
               // for (int j = 0; j < whe.length; j++) {

                     w.add(Wheel.valueOf(str[i]));
              //  }
            }
            wheels = w;
            System.out.println(wheels);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        new Car();
    }
}
