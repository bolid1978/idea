package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in =new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        int a=0,b=0;
        for (int i = 0; i <3 ; i++) {
            int c=Integer.parseInt(bufferedReader.readLine());
            if(c>0) {a++;continue;}
            if(c<0) {b++;}
        }
        System.out.println("количество отрицательных чисел: "+b);//напишите тут ваш код
        System.out.println("количество положительных  чисел: "+a);//напишите тут ваш код

    }
}
