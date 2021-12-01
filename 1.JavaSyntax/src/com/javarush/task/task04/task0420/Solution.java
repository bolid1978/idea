package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        int [] mass=new int[3];

        for (int i = 0; i <3 ; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }
        //int max=mass[0];
        for (int i = 0; i <3 ; i++) {
            for (int j = i; j <3 ; j++) {
               if(mass[i]<mass[j]) {int a=mass[i];mass[i]=mass[j];mass[j]=a;}
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(mass[i]);
        }

    }
}
