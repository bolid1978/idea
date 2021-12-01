package com.javarush.task.task19.task1920;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String oneArgs = "c:\\1\\one.txt";
        TreeMap<String ,Double> mapResul = new TreeMap<>();
        BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

        while (inFile.ready()){

            String [] str = inFile.readLine().split("\\s");

           // mapResul.merge(str[0],Double.parseDouble(str[1]),(a, b) -> b +  Double.parseDouble(str[1]));
            double a = 0;
            if(mapResul.containsKey(str[0])){
                a = mapResul.get(str[0]);
            }
            mapResul.put(str[0],Double.parseDouble(str[1]) + a);


        }
        inFile.close();
        ArrayList<Double> max = new ArrayList<>(mapResul.values());
        double maxValue = Collections.max(max);
      //  System.out.println(maxValue);

        for (Map.Entry<String,Double> pair: mapResul.entrySet()
             ) {
            if(pair.getValue() == maxValue) System.out.println(pair.getKey());
        }
      // System.out.println(max);
      //  System.out.println(mapResul);


    }
}
