package com.javarush.task.task09.task0922;

/*
Какое сегодня число?
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        //String str= "2013-08-18";
         String str =bufferedReader.readLine();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(str);
        SimpleDateFormat sim=new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        str=sim.format(date);
       // str="dssdfg";
        char[] characters= str.toCharArray();
        characters[1]=Character.toUpperCase(characters[1]);
        characters[2]=Character.toUpperCase(characters[2]);

        str=new String(characters);




        System.out.println(str);

        //System.out.println(myDate);


    }
}