package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        Reader reader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        FileInputStream fileInputStream = null;



        while(true){
        try {
            String str=bufferedReader.readLine();
             fileInputStream = new FileInputStream(str);
           break;
        }


        catch (FileNotFoundException e)
        {
            System.out.println("не правельный ввод имени файла");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        }
        ArrayList<Character> arrayList=new ArrayList<Character>();
        while (fileInputStream.available()!=0){
        arrayList.add((char)fileInputStream.read());
        }
        String str="";
        for (Character elem: arrayList
             ) {
            str+=(char)elem;
        }

        System.out.println(arrayList);
        System.out.println(str);
        fileInputStream.close();
        bufferedReader.close();

        // напишите тут ваш код
    }
}