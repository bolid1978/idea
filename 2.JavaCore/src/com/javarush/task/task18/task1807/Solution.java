package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;/*
Подсчет запятых
*/
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        int counter = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        try {
          file = new FileInputStream(str);

            while(file.available()>0){
                 int c = file.read();
           //     System.out.println(c);
                 if(c == (int)(',')) counter++;

            }


        }



         catch (IOException e){
             System.out.println("Что то не так с файлом");
         }
        finally {
            file.close();
            reader.close();
        }
        System.out.println(counter);
    }
}
