package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

         Iterator<Cat> iterator=cats.iterator();
        Cat it=iterator.next();
        cats.remove(it);
       // cats.remove(cats);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
       HashSet<Cat> cats=new HashSet<>();

       cats.add(new Cat());//напишите тут ваш код. step 2 - пункт 2
       cats.add(new Cat());//напишите тут ваш код. step 2 - пункт 2
       cats.add(new Cat());//напишите тут ваш код. step 2 - пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
       for (Cat elem:cats){
           System.out.println(elem);
       }
    }

   public static class Cat{


   } // step 1 - пункт 1
}
