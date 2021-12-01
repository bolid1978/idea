package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> allFile = new ArrayList<>();
       // String [] args = "";
        String argsOne = "c:\\1\\one.txt";
        String argsTwo = "c:\\1\\two.txt";
        BufferedReader inFile = null;
        try {
           inFile = new BufferedReader(new FileReader(args[0]));

        }
      catch (FileNotFoundException e){
          System.out.println("нет такого файла");

      }
        try {
            while (inFile.ready()) {
              String s = inFile.readLine();
              String [] str = s.split("\\s");
                for (String element: str
                     ) {
                    if(element.length() > 6) {

                        allFile.add(element);

                    }
                }

            }
          inFile.close();
        }

        catch (IOException e){
            System.out.println("не читаеться файл" + inFile);

        }

        //System.out.println(allFile);

        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        for (int i = 0 ,l = allFile.size(); i < l; i++) {
            writer.write(allFile.get(i));
            if(i!=l-1) {
                writer.write(",");
            }

        }
        writer.close();



    }
}
