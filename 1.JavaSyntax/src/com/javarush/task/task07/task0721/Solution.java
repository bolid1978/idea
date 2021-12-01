package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static int[] getInts() throws IOException {
        int [] mass=new int[20];
        Reader in =new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        for (int i = 0; i < 20; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }
        return mass;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] mass=getInts();
        int  maximum=mass[0];
        int minimum=mass[0];
        for (int i = 0; i <mass.length ; i++) {
            if(mass[i]<minimum) minimum=mass[i];
            if(mass[i]>maximum) maximum=mass[i];
        }

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
}
