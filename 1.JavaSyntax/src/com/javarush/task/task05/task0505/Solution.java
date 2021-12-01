package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {

    public static void main(String[] args) {

       Cat oneCat=new Cat("kety", 12, 33, 56); //напишите тут ваш код
       Cat twoCat=new Cat("ketyone", 16, 35, 5); //напишите тут ваш код
       Cat freeCat=new Cat("ketytwo", 18, 32, 54); //напишите тут ваш код
        System.out.println(oneCat.fight(twoCat));
        System.out.println(oneCat.fight(freeCat));
        System.out.println(twoCat.fight(freeCat));
    }

    public static class Cat {

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            int strengthScore = Integer.compare(this.strength, anotherCat.strength);

            int score = ageScore + weightScore + strengthScore;
            return score > 0; // return score > 0 ? true : false;
        }


    }
}
