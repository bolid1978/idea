package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String name=bufferedReader.readLine();
        int year =Integer.parseInt(bufferedReader.readLine());
        int moth =Integer.parseInt(bufferedReader.readLine());
        int day =Integer.parseInt(bufferedReader.readLine());



        System.out.println("Меня зовут "+name+".");
        System.out.printf("Я родился %d.%d.%d",day,moth,year);

    }
}
