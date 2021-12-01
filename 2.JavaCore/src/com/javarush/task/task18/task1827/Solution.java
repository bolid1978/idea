package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
      //  fileName = "c:\\1\\one.txt" ;
        String []str1  = {"-c", "Шорты пляжные синие", "159.00", "12"};
        String []str2  = {"-c", "Шорты пляжные черные с рисунком","173.00", "17"};
        String []str3  = {"-c", "Куртка для сноубордистов, разер большой", "10173.99", "1234"};
      //  args = str1;
        String id = "";
        int maxID = 0;
       // String test = "19847983";
       // String test0ne = str2[1];
       // String testtwo = str2[2];
       // String testtree = str2[3];

        reader.close();


        if(args.length!= 0){
             Reader rdSimbol = new InputStreamReader(new FileInputStream(fileName),"UTF-8");

             BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
             Pattern p = Pattern.compile("^\\d{0,8}");

            while (fileReader.ready()){

                String s = "";
                s = fileReader.readLine();

                Matcher matcher = p.matcher(s);
                while (matcher.find()) {
                   id =matcher.group();
                }


                if(Integer.parseInt(id) > maxID) maxID = Integer.parseInt(id);

            }
            fileReader.close();

             id = String.valueOf(maxID +1);

            String end = String.format("%-8.8s%-30.30s%-8.8s%-4.4s",id,args[1],args[2],args[3]);
            System.out.println(end);

            BufferedWriter writerInFile = new BufferedWriter(new FileWriter(fileName,true));
            writerInFile.newLine();
            writerInFile.write(end);


          writerInFile.close();









        }
    }
}
