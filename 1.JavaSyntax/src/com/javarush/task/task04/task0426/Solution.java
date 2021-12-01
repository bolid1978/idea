package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import javax.imageio.stream.ImageOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        int a= Integer.parseInt(bufferedReader.readLine());//напишите тут ваш код

        if(a<0&&a%2==0) System.out.println("отрицательное четное число");
        if(a<0&&a%2!=0) System.out.println("отрицательное нечетное число");
        if(a==0) System.out.println("ноль");
        if(a>0&&a%2==0) System.out.println("положительное четное число");
        if(a>0&&a%2!=0) System.out.println("положительное нечетное число");


    }
}