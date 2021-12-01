package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        String str =bufferedReader.readLine();
        int a =Integer.parseInt(bufferedReader.readLine());

        while(a-->0){
            System.out.println(str);
        }

        //напишите тут ваш код

    }
}
