package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        int a=Integer.parseInt(bufferedReader.readLine());
        int b=Integer.parseInt(bufferedReader.readLine());

        if(a>b) System.out.println(b);
        if(a<b) System.out.println(a);
        if(a==b) System.out.println(a);
    }
}