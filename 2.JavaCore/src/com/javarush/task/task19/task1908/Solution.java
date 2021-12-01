package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inFile = reader.readLine();
        String outFile = reader.readLine();

        reader.close();

        ArrayList<Integer> allFile = new ArrayList<>();
        BufferedReader oneFile = new BufferedReader(new FileReader(inFile));

        while (oneFile.ready()) {
            String s = "";
            s = oneFile.readLine();
            String[] str = s.split("\\s");
            for (String element : str
            ) {
                try {
                    allFile.add(Integer.parseInt(element));
                } catch (Exception e) {
                   // System.out.println("не преобразуеться в число " + element);
                }

            }
        }
        oneFile.close();
        //System.out.println(allFile);

        BufferedWriter twoFile = new BufferedWriter(new FileWriter(outFile));
        for (Integer el:allFile
             ) {
             twoFile.write(el + " ");

        }
         twoFile.close();

    }
}


