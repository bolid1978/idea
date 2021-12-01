package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {


    public static void main(String[] args) throws IOException {
      //   String oneArgs = "c:\\1\\one.txt";
        TreeMap<String,Double> mapResult = new TreeMap<String, Double>();
       BufferedReader reader = new BufferedReader(new FileReader(args[0]));

       // BufferedReader reader = new BufferedReader(new FileReader(oneArgs));
      //   BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(oneArgs), "windows-1251"));

        while(reader.ready()){
            double a = 0;
           String s  = reader.readLine();
           String [] str = s.split("\\s");
           if(mapResult.containsKey(str[0])) {
               a = mapResult.get(str[0]);
           }
               mapResult.put(str[0], Double.parseDouble(str[1]) + a);

        }
        reader.close();
        for (Map.Entry<String ,Double> pair: mapResult.entrySet()
             ) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
      //  System.out.println(mapResult);


    }
}
