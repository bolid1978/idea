package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(10, "десять");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static <ByteArrayInputStreamStream> void main(String[] args)  {
        ArrayList<String> allFile =new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile ="";
        try{
         inFile = reader.readLine();
        }
        catch (Exception e){
            System.out.println("Не правелный ввод данных");

        }
       finally {
            try{
                reader.close();
            }
            catch (Exception ex){
                System.out.println("не возможно закрыть поток");
            }
        }

        BufferedReader oneFile = null;
        try {
            oneFile = new BufferedReader(new FileReader(inFile));
        }
        catch (FileNotFoundException  ex){
            System.out.println( "Не найден файл " + inFile );
        }
        try {
            while (oneFile.ready()) {

              String s = oneFile.readLine();

              String []str = s.split("\\s");
             //   System.out.println(Arrays.toString(str));
                for (int i = 0 ,l = str.length; i < l; i++) {
                    for (Map.Entry<Integer,String> pair:map.entrySet()
                    ) {
                        if(str[i].equals(String.valueOf(pair.getKey()))) {
                            str[i] = pair.getValue();
                        }
                    }
                }

               // System.out.println(Arrays.toString(str));
                String res ="";
                for (String element: str
                     ) {
                    res+=element+" ";
                }
                allFile.add(res);
                System.out.println(res);


                }

             oneFile.close();

             }
        catch (Exception ex){
            System.out.println("Не читается файл");
            ex.fillInStackTrace();
        }



    }
}
