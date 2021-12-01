package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);// создай и заполни массив
        int [] mass=new int[20];
        for (int i = 0; i < 20; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }
        return mass;
    }

    public static int max(int[] array) {
        int max=array[0];
        for (int i = 0; i <20 ; i++) {
            if(max<array[i])  max=array[i];
        }
        // найди максимальное значение
        return max;
    }
}
