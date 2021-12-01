package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String firstName=bufferedReader.readLine();
        String twoName=bufferedReader.readLine();

        if (firstName.equals(twoName)) System.out.println("Имена идентичны");
        else if (firstName.length()==twoName.length()) System.out.println("Длины имен равны");


    }
}
