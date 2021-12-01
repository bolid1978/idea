package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat oneCat=new Cat("vaska", 10, 15, 2);
        Cat twoCat=new Cat("olesy", 1, 13, 4);
        Cat freeCat=new Cat("zebka", 13, 10, 1);
        //напишите тут ваш код
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }


    }


}