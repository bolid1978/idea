package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
      /*  BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();

        BufferedReader oneFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileOne), "windows-1251"));
        ArrayList<String> allOneFile= new ArrayList<>();
        while(oneFile.ready()){
            allOneFile.add(oneFile.readLine());

        }
        reader.close();
        oneFile.close();

       // System.out.println(allOneFile);
        Pattern pattern = Pattern.compile("\\s");

       // System.out.println(Arrays.toString(strOne));
        HashMap<Integer,String> result = new HashMap<>();
        for (String element: allOneFile
             ) {
            String [] strOne = pattern.split(element,2);
            result.put(Integer.parseInt(strOne[0]),strOne[1]);
        }
      //  System.out.println(result.toString());
       // args[0] ="1";
        System.out.println(result.get(Integer.parseInt("12")));
*/

         //   args = new String[1];
       //     args[0] = String.valueOf(12);

            BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));// считал имя
            try {                             // считал с файла одну строчку
                BufferedReader oneStringFromFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameReader.readLine())));
                fileNameReader.close();

                while (oneStringFromFileReader.ready()) {
                    String tovar = oneStringFromFileReader.readLine();
                    if (tovar.startsWith(args[0] + " ")) System.out.println(tovar);
                }

                oneStringFromFileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





