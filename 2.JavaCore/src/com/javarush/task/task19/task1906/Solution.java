package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> allChar =new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = "";
        String fileTwo = "";

        try{
         fileOne = reader.readLine();
         fileTwo = reader.readLine();

        }
        catch (Exception o){
            System.out.println("не правельный ввод файла");
        }
        FileReader fileReader = new FileReader(fileOne);

        while (fileReader.ready()){
            allChar.add(fileReader.read());
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(fileTwo);

        for (int i = 1,l = allChar.size(); i < l  ; i+=2) {
            fileWriter.write(allChar.get(i));
        }
        fileWriter.close();
        reader.close();

    }
}
