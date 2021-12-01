package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name,address;
    int age=1;
    int weight=1;
    String color="Red";

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name,  int weight,int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
       // String color="Red";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Cat( int weight, String color,String address) {
        this.address = address;
        this.weight = weight;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
