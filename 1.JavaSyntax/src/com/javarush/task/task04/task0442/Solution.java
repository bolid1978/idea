package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        int sum=0;
        while (true){
            int a=Integer.parseInt(bufferedReader.readLine());
            sum+=a;
            if(a==-1) break;
        }
        System.out.println(sum);
    }
}
