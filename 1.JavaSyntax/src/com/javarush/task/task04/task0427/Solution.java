package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {

    static void result(String a,String b){

        switch (a.length()){
            case 1:{
                System.out.println(b +" однозначное число");break;
            }
            case 2:{
                System.out.println(b +" двузначное число");break;
            }
            case 3:{
                System.out.println(b +" трехзначное число");break;
            }


        }
    }

    public static void main(String[] args) throws Exception {

        //напишите тут ваш код
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String a= bufferedReader.readLine();//напишите тут ваш код
        if(Integer.parseInt(a)%2==0){
            if (Integer.parseInt(a)!=0)
            result(a, "четное");
        }
            else{
            result(a, "нечетное");
        }

    }
}
