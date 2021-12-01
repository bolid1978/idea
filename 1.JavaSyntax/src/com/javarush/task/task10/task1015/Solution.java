package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> [] arrayLists=new ArrayList[3];

        arrayLists[0]=new ArrayList<String>();
        arrayLists[0].add("1");
        arrayLists[0].add("10");
        arrayLists[0].add("100");

        arrayLists[1]=new ArrayList<String>();
        arrayLists[1].add("2");
        arrayLists[2]=new ArrayList<String>();
        arrayLists[2].add("3");
        //напишите тут ваш код

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}