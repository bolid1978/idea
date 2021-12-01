package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = "";
       // byte [] temp
        while (true){
            inFile = reader.readLine();
            FileInputStream file = new FileInputStream(inFile);
            if(file.available()<1000){
                file.close();
                reader.close();
                throw new DownloadException();
            }






        }


    }
    public static class DownloadException extends Exception {

    }
}
