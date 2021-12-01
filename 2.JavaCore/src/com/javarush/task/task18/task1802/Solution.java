package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;/*
Минимальный байт
*/
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  String str = "c:\\1\\one.txt";
                String str = bufferedReader.readLine();
        FileInputStream file = new FileInputStream(str);
        int minByte = Integer.MAX_VALUE;
        while(file.available()>0){
            int minTemp = file.read();
            if(minTemp < minByte) minByte = minTemp;
        }
        System.out.println(minByte);
        file.close();
    }
}
