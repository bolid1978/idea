package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
      int vinthiscat=0;
      int vinothecat=0;
      int point=0;
    /*  if (this.age>anotherCat.age) vinthiscat++;else vinothecat++;
      if (this.weight>anotherCat.weight) vinthiscat++;else vinothecat++;
      if (this.strength>anotherCat.strength) vinthiscat++;else vinothecat++;
*/
        if (this.age>anotherCat.age) point++;else if(this.age<anotherCat.age) point--;
        if (this.weight>anotherCat.weight) point++;else if(this.weight<anotherCat.weight) point--;
        if (this.strength>anotherCat.strength) point++;else if(this.strength<anotherCat.strength) point--;

       // if(point==0) return true;
        if(point>0) return true;else return false;
      //напишите тут ваш код
    }

    public static void main(String[] args) {

        Cat cat1=new Cat();
        Cat cat2=new Cat();

        cat1.age=3;
        cat1.strength=2;
        cat1.weight=2;

        cat2.age=2;
        cat2.weight=2;
        cat2.strength=2;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }
}
