package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in= new InputStreamReader(System.in);//напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(in);

        int x=Integer.parseInt(bufferedReader.readLine());
        int y=Integer.parseInt(bufferedReader.readLine());

        if(x>0&&y>0) System.out.println("1");
        if(x<0&&y>0) System.out.println("2");
        if(x<0&&y<0) System.out.println("3");
        if(x>0&&y<0) System.out.println("4");
    }
}
