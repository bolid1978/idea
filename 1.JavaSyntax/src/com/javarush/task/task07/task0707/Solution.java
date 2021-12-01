package com.javarush.task.task07.task0707;

/* 
Что за список такой?
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {


        ArrayList<String> strmass=new ArrayList();

            strmass.add("one");
            strmass.add("two");
            strmass.add("free");
            strmass.add("four");
            strmass.add("five");


        System.out.println(strmass.size());
        for (String elem:strmass
        ) {
            System.out.println(elem);
    }
}
}
