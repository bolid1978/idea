package com.javarush.task.task18.task1817;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
         FileInputStream inFile = new FileInputStream("c:\\1\\one.txt");

        //byte [] mass = new byte[inFile.available()];
       // inFile.close();
       BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        int countProb=0;
        int countAll=0;
        char a ;
        while(reader.ready()){
            a = (char)reader.read();
            if(a ==' ') countProb++;
            countAll++;
        }
        reader.close();
       // System.out.println(countAll);
        //System.out.println(countProb);
        //double d= countAll/countProb*100;
        System.out.printf("%.2f",(double)countProb*100/countAll);
        //System.out.println(Arrays.toString(mass));



}
}
