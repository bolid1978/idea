package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Прайсы 2
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> allStringFile = new ArrayList<String>();
        String fileName = reader.readLine();
       // String fileName = "c:\\1\\one.txt";
        String[] str1 = {"-d", "198478", "Шорты пляжные синие", "159.00", "12"};
        String[] str2 = {"-c", "Шорты пляжные черные с рисунком", "173.00", "17"};
        String[] str3 = {"-c", "Куртка для сноубордистов, разер большой", "10173.99", "1234"};
       // args = str1;
        String id = "";
        //int maxID = 0;
        // String test = "19847983";
        // String test0ne = str2[1];
        // String testtwo = str2[2];
        // String testtree = str2[3];

        reader.close();


        if (args.length != 0) {

            if (args[0].equals("-u")) {


                BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
                Pattern p = Pattern.compile("^\\d{0,8}");

                while (fileReader.ready()) {
                    allStringFile.add(fileReader.readLine());
                }

                fileReader.close();
             //   System.out.println(allStringFile);

                 id = args[1];
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];

                allStringFile = updatelist(allStringFile, id, productName, price, quantity);
                /*for (String element : allStringFile
                ) {
                    Matcher matcher = p.matcher(element);
                    while (matcher.find()) {
                        id = matcher.group();

                    }
                    if (id.equals(args[1])) {
                        String end = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, args[2], args[3], args[4]);
                      //  System.out.println(end);
                        allStringFile.set(allStringFile.indexOf(element), end);
                    //    System.out.println(allStringFile);


                    }*/



                }
                recFile(allStringFile,fileName);
            }
                if (args[0].equals("-d")) {

                    BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                    Pattern p = Pattern.compile("^\\d{0,8}");

                    while (fileReader.ready()) {
                        allStringFile.add(fileReader.readLine());
                    }

                    fileReader.close();
                    System.out.println(allStringFile);
                    for (String element : allStringFile
                    ) {
                        Matcher matcher = p.matcher(element);
                        while (matcher.find()) {
                            id = matcher.group();

                        }
                        if (id.equals(args[1])) {
                          //  String end = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, args[2], args[3], args[4]);
                           // System.out.println(end);
                            allStringFile.remove(allStringFile.indexOf(element));
                           // System.out.println(allStringFile);


                        }



                    }
                    recFile(allStringFile,fileName);
                }


            }








        public static void recFile(ArrayList<String> allStringFile,String fileName) throws IOException {
            BufferedWriter writerInFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (String element : allStringFile
            ) {
                writerInFile.write(element);
                writerInFile.newLine();

            }
            writerInFile.close();

        }
    public static ArrayList<String> updatelist(ArrayList<String> listCrud, String id, String productName, String price, String quantity) {
        for (int i=0; i < listCrud.size(); i++) {
            String index = listCrud.get(i).substring(0,8).trim();
            if (id.equals(index)) {
                listCrud.set(i,String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity));
            }
        }
        return listCrud;
    }

    }
