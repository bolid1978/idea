package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {

            Reader in =new InputStreamReader(System.in);
            BufferedReader bufferedReader=new BufferedReader(in);
            int [] mass =new int[15];//напишите тут ваш код
            int counteven=0;
            int countodd=0;
            for (int i = 0; i < 15; i++) {
                mass[i]=Integer.parseInt(bufferedReader.readLine());
                if(i%2==0) counteven+=mass[i];else countodd+=mass[i];

            }
       // System.out.println(counteven +"   "+ countodd);
            if (counteven<countodd) System.out.println("В домах с нечетными номерами проживает больше жителей.");
            else System.out.println("В домах с четными номерами проживает больше жителей.");


        } //напишите тут ваш код
    }

