package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }



    public static void main(String[] args) {

         String [] argsI = {"i","1"};
         //String [] argsC = {"-c","Соловьева","ж","15/02/1980"};
      //  new Solution().Test(argsI);
       // args = argsI;
      //  args = argsC;
        switch (args[0]){
            case "-i":{
                SimpleDateFormat myData = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
                String str;
                str = allPeople.get(Integer.parseInt(args[1])).getName() + " ";

                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE))   str = str +"ж" + " ";
                else  str = str +"м" + " ";
                str = str + myData.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate());
                System.out.println(str);
                break;
            }
            //-----------------------------------------------
               case "-c":{
                String str = args[3];
                SimpleDateFormat myData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                try {
                   Date data = myData.parse(str);

                    if (args[2].equals("ж")) { allPeople.add(Person.createFemale(args[1],data));}
                    else{ allPeople.add(Person.createMale(args[1],data));}
                }
                catch (Exception e){
                    //System.out.println("ЛАЖА");
                }
                   System.out.println(allPeople.size()-1);
                break;
           }
            //--------------------------------------
            case "-d":{
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);

                break;
            }
            case "-u":{
                String str = args[4];
                SimpleDateFormat myData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                try {
                    Date data = myData.parse(str);

                    if (args[3].equals("ж")) {
                        allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                        allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.parseInt(args[1])).setBirthDate(data);
                    }
                    else{
                        allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                        allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                        allPeople.get(Integer.parseInt(args[1])).setBirthDate(data);
                    }
                }
                catch (Exception e){
                    //System.out.println("ЛАЖА");
                }
              //  System.out.println(allPeople.size()-1);
                break;

            }

        }
        //start here - начни тут
    }
}
