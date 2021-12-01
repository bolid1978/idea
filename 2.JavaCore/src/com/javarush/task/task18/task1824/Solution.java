package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //FileInputStream fileInputStream = null;
        String str="";
        try {
            while(true){
             str = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(str);
            fileInputStream.close();
            }
        }
        catch (FileNotFoundException ex){
            System.out.println(str);
          //  fileInputStream.close();
        }
        reader.close();


    }
}
