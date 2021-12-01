package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> allFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oneFile = "";
        String twoFile = "";

        try{
        oneFile = reader.readLine();
        twoFile = reader.readLine();
    }
        catch (Exception e){
            System.out.println("не правельный файл");
        }
        reader.close();

        BufferedReader fileIn = new BufferedReader(new FileReader(oneFile));
        while(fileIn.ready())  {

            String s = fileIn.readLine();
        //    System.out.println(s);
             s = s.replaceAll("\\.", "!");
          //  System.out.println(s);
            allFile.add(s);
        }
        fileIn.close();

        BufferedWriter fileOut = new BufferedWriter(new FileWriter(twoFile));
        for (String element: allFile
             ) {
            fileOut.write(element);
            fileOut.newLine();
        }
        fileOut.close();

    }
}
