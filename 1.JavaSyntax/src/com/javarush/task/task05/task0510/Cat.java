package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Cat должна быть переменная name с типом String.
3. У класса Cat должна быть переменная age с типом int.
4. У класса Cat должна быть переменная weight с типом int.
5. У класса Cat должна быть переменная address с типом String.
6. У класса Cat должна быть переменная color с типом String.
7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
11. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age = 1;
    int weight = 1;
    String address;
    String color = "Red";

    public void initialize(String name) {
        this.name = name;
        //this.age=1;
        //this.weight=1;
        //this.color="color";
    }
    public void initialize(String name,  int weight,int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        //  this.color=0;
    }
    public void initialize(String name,int age) {
        this.name = name;
        this.age = age;
        //  this.weight=weight;
        //  this.color=0;
    }



    public void initialize(int weight, String color) {
        //this.name = name;
        //this.age=age;
        this.weight= weight;
        this.color = color;
    }

    public void initialize(int weight,String color,String address){
       // this.name=name;
       // this.age=age;
        this.weight=weight;
        this.color=color;
        this.address=address;


    }

    public static void main(String[] args) {

    }
}
