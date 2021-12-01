package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        int m=Integer.parseInt(reader.readLine());

        ArrayList <String> strings=new ArrayList<String>();
        ArrayList <String> stringstemp=new ArrayList<String>();

        for (int i  = 0; i < n ; i++) {
            strings.add(reader.readLine());
        }
        strings.addAll(strings.subList(0, m));
        strings.removeAll(strings.subList(0, m));
        for (String element: strings
             ) {
            System.out.println(element);
        }


        //напишите тут ваш код
    }
}
