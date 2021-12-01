package com.javarush.task.task18.task1803;

/*
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // String str = "c:\\1\\one.txt";
        String str = bufferedReader.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList <Integer> freq = new ArrayList<>();

        FileInputStream file = new FileInputStream(str);

        while(file.available()>0){
            arrayList.add(file.read());
        }
        file.close();
         // System.out.println(arrayList);
        for (int i = 0,l = arrayList.size(); i < l; i++) {
            freq.add(Collections.frequency(arrayList, arrayList.get(i)));
        }
         //  System.out.println(freq);
        int max = 0;

        for (int i = 0 , l = freq.size(); i < l ; i++) {

            if(freq.get(i) > max ) max = freq.get(i);
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0 ,l = freq.size(); i < l; i++) {

            if(freq.get(i) == max) set.add(arrayList.get(i));
        }
        for (Integer element:set
             ) {
            System.out.print(element + " ");
        }
        System.out.println();
        // System.out.println(minByte);
        //file.close();

    }



}
