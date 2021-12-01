package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
       String oneFile = "c:\\1\\one.txt";

        BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

        while (inFile.ready()){
            String s = inFile.readLine();

            String [] strName = s.split("\\s\\d+",0);
            String [] strDate = s.split("\\W+");
            int day = Integer.parseInt(strDate[strDate.length-3]);
            int moth = Integer.parseInt(strDate[strDate.length-2]);
            int year = Integer.parseInt(strDate[strDate.length-1]);
           // System.out.println(Arrays.toString(strName));
           // System.out.println(Arrays.toString(strDate));

            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

           // Date birthDate = new Date(year,moth,day);
            Date birthDate = dateFormat.parse(strDate[strDate.length-3] +" "+ strDate[strDate.length-2] +" " +strDate[strDate.length-1]) ;
            Person person = new Person(strName[0],birthDate);
           // System.out.println(person.getName());
          //  System.out.println(person.getBirthDate());

            PEOPLE.add(person);






        }
        inFile.close();


    }
}
