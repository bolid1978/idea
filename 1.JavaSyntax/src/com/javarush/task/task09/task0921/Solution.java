package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        readData();
    }

    public static void readData()  {
        Reader in= new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(in);
        ArrayList <Integer> list=new ArrayList<>();
        int a = 0;
        while(true){
        try{
             a=Integer.parseInt(reader.readLine());
        }
       catch (NumberFormatException | IOException e){
           for (Integer element:list){
               System.out.println(element);
           };break;

       }
        list.add(a);
        }

        //напишите тут ваш код
    }
}
