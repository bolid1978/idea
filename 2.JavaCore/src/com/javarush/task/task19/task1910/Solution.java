package com.javarush.task.task19.task1910;

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
            reader.close();
        }
        catch (Exception e){
            System.out.println("нет такого файла");
        }

       BufferedReader inFile = new BufferedReader(new FileReader(oneFile));

       while (inFile.ready()){
           String out ="";
           String s = inFile.readLine();
         //  System.out.println(s);
         //  Pattern p = Pattern.compile("([A-Za-z0-9])+");
        //   Matcher matcher =p.matcher(s);
        //   while (matcher.find()){

         //      out +=matcher.group();
        //   }
           out = s.replaceAll("[\\p{Punct}\\n]","");
                allFile.add(out);
           //System.out.println(out);

       }
       inFile.close();

        BufferedWriter outFile = new BufferedWriter(new FileWriter(twoFile));

        for (String element:allFile
             ) {
            outFile.write(element);
            outFile.newLine();
        }
        outFile.close();

    }
}
