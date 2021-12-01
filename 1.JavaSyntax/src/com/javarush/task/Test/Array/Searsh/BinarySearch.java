package com.javarush.task.Test.Array.Searsh;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {

    public static boolean binarySearch(int [] array,int key) {

        int mid = 0;
        int min = 0;
        int max = array.length;
        mid = (max + min) / 2;


        while (mid > 0) {
            mid = (max + min) / 2;
            if (key > array[mid]) {
                //--------уходим в право
                min = mid;
            } else if (key < array[mid]) {
                //----------------уходим влево
                max = mid;

            } else
                if (key == array[mid]) return true;




        }
        return false;
    }
    public static void main(String[] args) {
        ThreadLocalRandom cifra =ThreadLocalRandom.current();

        int [] array=new int[25];
        for (int i = 0; i < array.length ; i++) {
            array[i]=cifra.nextInt(5,51);
        }
         Arrays.sort(array);

        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array,300 /*array[14]*/));

    }


}
