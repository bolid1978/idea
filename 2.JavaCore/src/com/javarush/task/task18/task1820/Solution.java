package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.regex.Pattern;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String one = reader.readLine();
        String two = reader.readLine();
        String data = "";
        BufferedReader dataOne = new BufferedReader(new FileReader(one));
        BufferedWriter dataTwo = new BufferedWriter(new FileWriter(two));

        while (dataOne.ready()){
            data = dataOne.readLine();
            Pattern pattern = Pattern.compile("\\s");
            String [] str = pattern.split(data);
          //  System.out.println(Arrays.toString(str));
            String out ="";
            for (String element:str
                 ) {
                element = String.valueOf(Math.round(Double.parseDouble(element)));
                out = out + element + " ";
               // System.out.println(element);
            }
           // System.out.println(out);

               dataTwo.write(out);

        }
            dataOne.close();
        dataTwo.close();
        reader.close();
    }
}
