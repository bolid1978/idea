package com.javarush.task.task06.task0610;

/* 
Класс ConsoleReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConsoleReader {
    public static String readString() throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);//напишите тут ваш код

        return bufferedReader.readLine();
    }

    public static int readInt() throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);//напишите тут ваш код

        return Integer.parseInt(bufferedReader.readLine()); //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);//напишите тут ваш код

        return Double.parseDouble(bufferedReader.readLine());//напишите тут ваш код //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);//напишите тут ваш код

        return Boolean.parseBoolean(bufferedReader.readLine());

    }

    public static void main(String[] args) throws Exception {

    }
}
