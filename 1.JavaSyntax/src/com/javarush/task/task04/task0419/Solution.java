package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        int max=0;
        int a=Integer.parseInt(bufferedReader.readLine());
        int b=Integer.parseInt(bufferedReader.readLine());
        int c=Integer.parseInt(bufferedReader.readLine());
        int d=Integer.parseInt(bufferedReader.readLine());
        max=a;
        if(b>max) max=b;
        if(c>max) max=c;
        if(d>max) max=d;

        System.out.println(max);

    }
}
