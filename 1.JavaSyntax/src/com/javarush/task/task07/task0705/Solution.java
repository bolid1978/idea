package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);// создай и заполни массив
        int [] mass=new int[20];
        int [] massone=new int[10];
        int [] masstwo=new int[10];



        for (int i = 0; i < 20; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i <10 ; i++) {
            massone[i]=mass[i];
        }

        masstwo= Arrays.copyOfRange(mass, 10, 20);
        /*for (int i = 0; i <10 ; i++) {
            masstwo[i]=mass[i+10];
        }*/
        /*for (int i = 0; i <10 ; i++) {
            System.out.println(masstwo[i]);
        }*/
        System.out.println((Arrays.toString(masstwo)));
    }
}
