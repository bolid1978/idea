package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws Exception {
        BigDecimal onecifra=new BigDecimal(0.3);
       Reader in =new InputStreamReader(System.in);
       BufferedReader bufferedReader=new BufferedReader(in);
       double sum=0;
       int counter=0;
        System.out.println(Integer.MAX_VALUE);
       while(true){

           int c=Integer.parseInt(bufferedReader.readLine());
           if (c!=-1) {sum+=c; counter++;}  else {sum=sum/counter;break;}
       }
        System.out.println(sum);
    }
}

