package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш ко
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        int [] mass=new int[3];
        for (int i = 0; i <3 ; i++) {
            mass[i]=Integer.parseInt(bufferedReader.readLine());
        }
        int min=mass[0];
        for (int i = 0; i <3 ; i++) {
            for (int j = i; j <3 ; j++) {
                if(mass[i]>mass[j]) {int a=mass[i];mass[i]=mass[j];mass[j]=a;}
            }
        }
        System.out.println(mass[1]);
    }
}
