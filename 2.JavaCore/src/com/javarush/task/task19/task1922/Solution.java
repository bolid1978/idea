package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inFile = reader.readLine();
        reader.close();
        BufferedReader oneFile = new BufferedReader((new FileReader(inFile)));
        while (oneFile.ready()){

            String s = oneFile.readLine();
          //  System.out.println(s);

            String str[] = s.split("[^а-яА-Я\\w]");
          //  System.out.println(Arrays.toString(str));
            int counter = 0;
            for (String element:words
                 ) {
                for (String el:str
                    ) {
                    if(el.equals(element)) counter++;
                }

            }
            if(counter == 2) System.out.println(s);



        }
         oneFile.close();
    }
}
