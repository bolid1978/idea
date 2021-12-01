package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String str = "";
        int symbol = 0;
        if(reader == null) return str;
        while ((symbol = reader.read())!=-1){
            symbol = symbol + key;
          //  str = str + Character.toString(symbol);
             char d = (char)symbol;
             str = str + String.valueOf(d);
           // System.out.println(d);
        }
        return str;
    }
}
