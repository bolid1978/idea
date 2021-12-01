package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);//напишите тут ваш код
        BufferedReader bufferedReader=new BufferedReader(in);

        int  one =Integer.parseInt(bufferedReader.readLine());
        int  two =Integer.parseInt(bufferedReader.readLine());
        int  free =Integer.parseInt(bufferedReader.readLine());

        if(one==two) System.out.println("3");
        if(one==free) System.out.println("2");
        if(two==free) System.out.println("1");
    }
}
