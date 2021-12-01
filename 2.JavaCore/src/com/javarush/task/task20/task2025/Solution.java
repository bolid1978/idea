package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа
*/


public class Solution {

    static {
        long[][] pow = new long[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < Long.MAX_VALUE; j++) {
                pow[i][j] = (long)Math.pow(i, 3);
                System.out.print(pow[i][j]+ "   ");

            }
            System.out.println();
        }

    }

    // возвращает массив цыфр из которых состоит число
    public static ArrayList<Integer> quality(long i){


        ArrayList<Integer> cifri = new ArrayList<Integer>();

        Integer ost = 0;
        while(i > 0){
            ost = (int)(i % 10);

            i = i/10;
            cifri.add(cifri.size(),ost);
        }
        System.out.println(cifri);
        return cifri;
    }


    public static long[] getNumbers(long N) {
        quality(95698785423L);

        long[] result = null;
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
