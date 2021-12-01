package com.javarush.task.task07.task0704;

/* 
Переверни массив
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in =new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        int [] mass =new int[10];//напишите тут ваш код
        for (int i = 0; i < 10; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 9; i >=0 ; i--) {
            System.out.println(mass[i]);
        }
    }
}

