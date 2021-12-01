package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {
         Airplane airplane=new Airplane();
         airplane.fly();
         airplane.run();
        String str="  12 kjhk 56   ";
      //     String s=str.trim();


    }

    public interface CanFly {
        public void fly();
         int a=10;


    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }




    public class Human implements CanRun,CanSwim {

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements CanRun,CanSwim,CanFly {

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements CanSwim,CanRun{


        @Override
        public void run() {
           // System.out.println(a);
        }

        @Override
        public void swim() {

        }
    }

    public static class Airplane implements CanFly,CanRun {

        @Override
        public void fly() {
            System.out.println(a);
        }


        public void run() {

        }
    }
}
