package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
       // String string="мама мыла раму";
        char[] mass=new char[string.length()];
        mass=string.toCharArray();
        mass[0]=Character.toUpperCase(mass[0]);
        for (int i = 1; i <mass.length ; i++) {
            if(mass[i-1]==' ') {
               mass[i]=Character.toUpperCase(mass[i]);
            }
        }
           String test=new String(mass);

        //System.out.println(string);
        System.out.println(test);

        //напишите тут ваш код
    }
}
