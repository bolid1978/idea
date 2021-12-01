package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String firstName=bufferedReader.readLine();
        for (int i = 0; i <10 ; i++) {
            System.out.println(firstName+ " любит меня.");
        }
        //напишите тут ваш код

    }
}
