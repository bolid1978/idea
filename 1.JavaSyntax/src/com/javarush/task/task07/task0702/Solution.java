package com.javarush.task.task07.task0702;

/* 
Массив из строчек в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);// создай и заполни массив
        String [] mass=new String[10];
        for (int i = 0; i < 8; i++) {
            mass[i]=bufferedReader.readLine();
        }
        for (int i = 9; i >=0 ; i--) {
            System.out.println(mass[i]);
        }
    }
}