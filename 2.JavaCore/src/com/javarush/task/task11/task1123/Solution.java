package com.javarush.task.task11.task1123;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        ThreadLocalRandom cifra= ThreadLocalRandom.current();
        for (int i = 0; i <1000000 ; i++) {
            data[i]=cifra.nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Date start=new Date();


        Pair <Integer, Integer> result = getMinimumAndMaximum(data);
        Date stop=new Date();
        System.out.println(stop.getTime()-start.getTime());
        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
       //  int max=-Integer.MIN_VALUE;
        // int min=Integer.MAX_VALUE;
        // int l=inputArray.length;
      //  for (int i = 0; i < l; i++) {
       //     if(inputArray[i]>max) max=inputArray[i];
       //     if(inputArray[i]<min) min=inputArray[i];
       // }
         //напишите тут ваш код
         int min = Arrays.stream(inputArray).min().getAsInt();
         int max = Arrays.stream(inputArray).max().getAsInt();

        return new Pair<Integer, Integer>(min, max);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
