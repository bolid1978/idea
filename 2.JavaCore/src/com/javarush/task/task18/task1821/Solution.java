package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        String str = "c:\\1\\one.txt";
        str = args[0];
        TreeMap<Integer,Integer> allByte = new TreeMap();

        try {
            BufferedInputStream infile = new BufferedInputStream(new FileInputStream(str));
            int a=10;
            while(true) {
               a = infile.read();
               if(a<=0) break;
              //  System.out.print(a+" ");
               if (allByte.containsKey(a)) {
                    allByte.put(a, allByte.get(a)+1);
               }
               else {
                   allByte.put(a, 1);
               }

            }
            infile.close();
        }
        catch (Exception e){
            System.out.println("Что то не так с файлом");
            System.out.println(e.toString());
        }

        System.out.println();
        for (Map.Entry<Integer,Integer> pair : allByte.entrySet()
             ) {
            System.out.println((char)((int)pair.getKey()) + " " + pair.getValue() );
        }
    }
}
