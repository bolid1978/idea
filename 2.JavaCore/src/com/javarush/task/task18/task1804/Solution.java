package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // String str = "c:\\1\\one.txt";
        String str = bufferedReader.readLine();
        ArrayList <Integer> arrayList = new ArrayList<>();
        ArrayList <Integer> freq = new ArrayList<>();

        FileInputStream file = new FileInputStream(str);

        while(file.available()>0){
            arrayList.add(file.read());
        }
        file.close();
      //  System.out.println(arrayList);
        for (int i = 0,l = arrayList.size(); i < l; i++) {
            freq.add(Collections.frequency(arrayList, arrayList.get(i)));
        }
     //   System.out.println(freq);
        int min = Integer.MAX_VALUE;

        for (int i = 0 , l = freq.size(); i < l ; i++) {

            if(freq.get(i) < min ) min = freq.get(i);
        }

        for (int i = 0 ,l = freq.size(); i < l; i++) {

            if(freq.get(i) == min) System.out.print(arrayList.get(i)+" ");
        }


       // System.out.println(minByte);
        //file.close();

    }
}
