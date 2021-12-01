package com.javarush.task.task22.task2209;

/*
Составить цепочку слов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args)  {
        //...
        String str= "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
           str = reader.readLine();
        }
        catch (IOException ex){

        }

        try(BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8")))
        {
           str = "";
           while(inFile.ready()){
               str  = str + inFile.readLine() + " ";
           }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String []res = str.split("\\s");
      //  getLine(res);



        StringBuilder result = getLine(res);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(words));


       while( !search(myList)  ) {
           Collections.shuffle(myList);
       }
       StringBuilder stringBuilder = new StringBuilder();
        for (String element:myList
             ) {
            stringBuilder.append(element);
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    public static boolean search(ArrayList<String> myLyst){
        ArrayList<String> resList = myLyst;
      //  System.out.println(myLyst);
        boolean result = true;
        for (int i = 0,l = myLyst.size()-1; i < l; i++) {
            String current = resList.get(i);
            String next = resList.get(i+1);
            char end = Character.toUpperCase(current.charAt(current.length()-1));
            char first = Character.toUpperCase(next.charAt(0));
            if(end!=first) {
                result = false;
                break;
            }

        }


        return result;
    }

}
