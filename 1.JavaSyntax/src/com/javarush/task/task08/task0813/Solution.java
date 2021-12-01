package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        HashSet<String> hashSet=new HashSet<String>();
        for (int i = 0; i < 20; i++) {
            hashSet.add("Л"+i) ;
        }
      //  System.out.println(hashSet.toString());
        //напишите тут ваш код
        return hashSet;
    }

    public static void main(String[] args) {
          createSet();

    }
}
