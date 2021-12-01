package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        reader.close();
        BufferedReader oneFile = new BufferedReader(new FileReader(inFile));

        while (oneFile.ready()){

            String str = oneFile.readLine();
            StringBuilder stringBuilder = new StringBuilder(str);
            str = stringBuilder.reverse().toString();

            System.out.println(str);


        }
        oneFile.close();


    }
}
