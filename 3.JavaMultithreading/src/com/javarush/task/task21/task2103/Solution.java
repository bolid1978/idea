package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
       // return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;
    }

    public static void main(String[] args) {
        System.out.print(calculate(false, false, false, true) +" ");
        System.out.print(calculate(false, false, true, false)+ " ");
        System.out.print(calculate(false, false, true, true) +" ");
        System.out.print(calculate(false, true, false, false) + " ");
        System.out.print(calculate(false, true, false, true)+" ");
        System.out.print(calculate(false, true, true, false)+" ");
        System.out.print(calculate(false, true, true, true)+" ");
        System.out.print(calculate(true, false, false, false)+ " ");
        System.out.println();
        System.out.print(calculate(true, false, false, true)+ " ");
        System.out.print(calculate(true, false, true, false)+ " ");
        System.out.print(calculate(true, false, true, true)+ " ");
        System.out.print(calculate(true, true, false, false)+ " ");
        System.out.print(calculate(true, true, false, true)+ " ");
        System.out.print(calculate(true, true, true, false)+ " ");
        System.out.print(calculate(true, true, true, true)+ " ");
        System.out.print(calculate(false, false, false, false)+ " ");


    }
}

