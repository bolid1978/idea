package com.javarush.task.task18.task1816;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

/*
        Reader reader = new FileReader(args[0]);



        int a,count = 0;
        while (true){
            a = reader.read();
            if(a == -1) break;
            else{
                Character b = (char) a;
                if (Character.isLetter(b)) count++;
            }
        }

        reader.close();
        System.out.println(count);


    }*/
        FileInputStream stream = new FileInputStream(args[0]);
        int count = 0;
        while(stream.available() > 0){
            byte data =(byte) stream.read();
            if (Character.isLetter(data ))
                count++;
        }
        stream.close();
        System.out.println(count);

    }
}
