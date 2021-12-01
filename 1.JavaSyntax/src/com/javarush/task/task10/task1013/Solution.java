package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private int weith;
        private String name;
        private String secondName;
        private String mather;
        private String father;

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, int weith) {
            this.age = age;
            this.weith = weith;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Human(int age, int weith, String name) {
            this.age = age;
            this.weith = weith;
            this.name = name;
        }

        public Human(int age, int weith, String name, String secondName) {
            this.age = age;
            this.weith = weith;
            this.name = name;
            this.secondName = secondName;
        }

        public Human(int age, int weith, String name, String secondName, String mather) {
            this.age = age;
            this.weith = weith;
            this.name = name;
            this.secondName = secondName;
            this.mather = mather;
        }

        public Human(int age, int weith, String name, String secondName, String mather, String father) {
            this.age = age;
            this.weith = weith;
            this.name = name;
            this.secondName = secondName;
            this.mather = mather;
            this.father = father;
        }

        public Human(String name, String secondName, String mather, String father) {
            this.name = name;
            this.secondName = secondName;
            this.mather = mather;
            this.father = father;
        }

        public Human(int age, String name, String secondName, String mather) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.mather = mather;
        }

        public Human(){}
    }
}
