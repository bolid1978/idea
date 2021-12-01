package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

/* 
Номер месяца
January - январь
February - февраль
March - март
April - апрель
May - май
June - июнь
July - июль
August - август
September - сентябрь
October - октябрь
November - ноябрь
December - декабрь
"May is the 5 month".
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        HashMap<String,Integer> map=new HashMap<String, Integer>();
        map.put("January",1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        Reader in= new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String a= bufferedReader.readLine();
        System.out.println(a+" is the "+map.get(a)+" month");

        //напишите тут ваш код
    }
}
