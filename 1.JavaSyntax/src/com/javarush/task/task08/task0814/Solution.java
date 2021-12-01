package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        HashSet<Integer> set=new HashSet<Integer>() ;

        set.add(10);
        set.add(12);
        set.add(1300);
        set.add(120);
        set.add(121);
        set.add(9);
        set.add(2);
        set.add(3);
        set.add(122);
        set.add(123);
        set.add(14);
        set.add(125);
        set.add(167);
        set.add(128);
        set.add(129);
        set.add(130);
        set.add(140);
        set.add(1150);
        set.add(14567);
        set.add(14587);
       // System.out.println(set);
         return set;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
           Integer cifra=iterator.next();
            if(cifra>10) {
                set.remove(cifra);
                iterator= set.iterator();
            }
        }
        // напишите тут ваш код
     //   System.out.println(set);
         return set;
    }

    public static void main(String[] args) {
         removeAllNumbersGreaterThan10(createSet());
    }
}
