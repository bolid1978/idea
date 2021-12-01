package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static  String fileOne = "c:\\1\\one.txt";
    public static  String fileTwo = "c:\\1\\two.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        fileOne = bufferedReader.readLine();
        fileTwo = bufferedReader.readLine();

        FileReader fileReader = new FileReader(fileOne);
        FileReader fileReader1 = new FileReader(fileTwo);
        BufferedReader reader = new BufferedReader(fileReader);
        BufferedReader reader1 = new BufferedReader(fileReader1);
        while (reader.ready()){
            allLines.add( reader.readLine());
        }
        while (reader1.ready()){
            forRemoveLines.add( reader1.readLine());
        }
        fileReader.close();
        fileReader1.close();
        reader.close();
        reader1.close();
       // System.out.println(forRemoveLines);
       // System.out.println(allLines);




        new Solution().joinData();
       // System.out.println(allLines);

    }

    public void joinData() throws CorruptedDataException {
          if(allLines.containsAll(forRemoveLines)) {
              allLines.removeAll(forRemoveLines);
          }
          else {
              allLines.clear();
              throw new CorruptedDataException();
          }
        }
        // если исключение не было



}
