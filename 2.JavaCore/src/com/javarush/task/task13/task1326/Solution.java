package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

       BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
       String str;
      //  str="c:\\1\\1.txt";
       // System.out.println(str);
       str = bufferedReader.readLine();

       BufferedReader file =new BufferedReader(new InputStreamReader(new FileInputStream(str)));

       ArrayList<Integer> arrayList=new ArrayList<Integer>();

      while (file.ready()){

         arrayList.add(Integer.parseInt(file.readLine()));

      }
        // System.out.println(arrayList);
         file.close();
         int count=0;
         for (int i = 0; i <arrayList.size();  i++) {
            if(arrayList.get(i) %2==0) count++;
        }
         int [] mass=new int[count];
        for (int i = 0,j=0; i < arrayList.size() ; i++) {
             if(arrayList.get(i)%2==0) {mass[j]=arrayList.get(i);j++;}
        }


        Arrays.sort(mass);
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
        file.close();
        // напишите тут ваш код
    }
}
