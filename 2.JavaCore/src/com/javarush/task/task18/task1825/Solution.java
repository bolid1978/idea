package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> allNameFile = new ArrayList<>();
        String nameFile = "";

        TreeMap<Integer, String> duei = new TreeMap<Integer, String>();
        String[] nameFileOut = new String[0];
        //-----------ввод имен------------------------------------
        while (true) {
            try {
                nameFile = reader.readLine();
            } catch (Exception e) {

            }

            if (nameFile.equals("end")) break;
            allNameFile.add(nameFile);
        }
        //---------парсиг------------------------------------------
        try {
            Pattern p = Pattern.compile("\\.\\w+$");
            nameFileOut = new String[2];
            nameFileOut = p.split(allNameFile.get(0));
            System.out.println(nameFileOut[0]);
            // System.out.println(file[1]);

            p = Pattern.compile("\\d+$");

            String index = "";
            Matcher matcher;
            for (String element : allNameFile
            ) {
                matcher = p.matcher(element);
                while (matcher.find()) {
                    index = matcher.group(0);

                }
                duei.put(Integer.parseInt(index), element);
            }
            System.out.println(duei);
        } catch (PatternSyntaxException e) {
            e.getDescription();
        }
//------------------запись файла---------------------------------

        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(nameFileOut[0], true));

        Iterator interator = duei.entrySet().iterator();
        while (interator.hasNext()) {

            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) interator.next();

            BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(entry.getValue()));

            byte[] mass = new byte[fileIn.available()];
            fileIn.read(mass);
            fileIn.close();
            fileOut.write(mass);


        }
        fileOut.close();
        reader.close();






    }
}
