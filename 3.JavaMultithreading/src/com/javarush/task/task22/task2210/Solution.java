package com.javarush.task.task22.task2210;

/*
StringTokenizer
*/

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
         String str ="level22.lesson13.task01";
         String slit =".";
        System.out.println(Arrays.toString(getTokens(str, slit)));
    }

    public static String[] getTokens(String query, String delimiter) {

        StringTokenizer  stringTokenizer = new StringTokenizer(query,delimiter);
        String [] result = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreElements()){
            result [i] = stringTokenizer.nextToken();
            i++;
        }

        return result;
    }
}
