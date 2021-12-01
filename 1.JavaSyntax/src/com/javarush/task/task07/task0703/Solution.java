package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);// создай и заполни массив
        int [] massint=new int[10];
        String [] massstr=new String[10];
        for (int i = 0; i < 10; i++) {
            massstr[i]=bufferedReader.readLine();
            massint[i]=massstr[i].length();
        }

        for (Integer elem:massint
             ) {
            System.out.println(elem);
        }
    }
}
