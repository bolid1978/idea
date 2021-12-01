package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> allFile = new ArrayList<String>();
        String oneArgs = "c:\\1\\one.txt";
        String twoArgs = "c:\\1\\two.txt";

        BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

        while(inFile.ready()){
            String s = inFile.readLine();
            String str [] = s.split("\\s");
         //   System.out.println(s);
            for (String element:str
                 ) {
            //    System.out.println(element);
                if(element.matches("\\S*\\d+\\S*")) {
                    allFile.add(element);
                }
            }


        }
        inFile.close();
      //  System.out.println(allFile);
        BufferedWriter writer =new BufferedWriter(new FileWriter(args[1]));
        for (String element :allFile
             ) {
            writer.write(element + " ");
        }
        writer.close();
    }
}
