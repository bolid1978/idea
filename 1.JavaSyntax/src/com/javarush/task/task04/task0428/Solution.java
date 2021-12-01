package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш
        Reader in =new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);
        int count=0;
        for (int i = 0; i <3 ; i++) {
            if(Integer.parseInt(bufferedReader.readLine())>0) count++;
        }
        System.out.println(count);

    }
}
