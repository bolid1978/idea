package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        String inFile = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
             inFile = reader.readLine();

        }
        catch (Exception e){
            System.out.println("нет такого файла");

        }
         finally {
            reader.close();
        }
        ArrayList<String> allWord = new ArrayList<>();
        BufferedReader oneFile = new BufferedReader(new FileReader(inFile));
      /*  int counter = 0;
        while (oneFile.ready()){
            String s = "";
            s = oneFile.readLine();
            Pattern p = Pattern.compile("[\\p{Punct}]");
            String [] str = p.split(s);
            for (String el:str
                 ) {
                if(el.equals("world")) counter++;
            }
           // System.out.println(Arrays.toString((str)));



        }

        oneFile.close();


*/
        int count = 0;
        while (oneFile.ready()){
            String text = oneFile.readLine();
            String[] world = text.replaceAll("[\\pP]", " ").split(" ");
            for (int i = 0; i < world.length; i++) {
                if(world[i].equals("world")){
                    count++;
                }
            }
        }
        System.out.println(count); oneFile.close();
    }

}
