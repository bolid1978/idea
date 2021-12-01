package com.javarush.task.task17.task1711;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }





    public static void main(String[] args) throws IOException {
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // String [] argsC = {"-c", "Миронов", "м", "15/04/1990", "Миронова" ,"ж", "25/03/1997"};
         //  String [] argsU = {"-u", "1","Фронов", "м", "5/Apr/1980","0","Смирнова", "ж", "11/Apr/1999"};
        //  String [] argsI = {"-i", "0", "1", "2", "3"};
       //   String [] argsD = {"-d", "1", "2", "3"};
       //   String [] argsI2 = {"-i",  "0"};
        //  args = argsU;



            switch (args[0]) {

                case "-c": {
                    SimpleDateFormat myDate = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    synchronized (allPeople){
                    for (int i = 1, l = args.length; i < l; ) {
                        try{
                             String str = args[i+2];
                             date =myDate.parse(str);}
                        catch (Exception e){

                        }
                        if (args[i + 1].equals("м")) {

                            allPeople.add(Person.createMale(args[i], date));


                        }
                         else {
                            allPeople.add(Person.createFemale(args[i], date));


                        }
                        System.out.println(allPeople.size() - 1);
                        i += 3;
                    }

                }
                break;
                }
                //------------------------------------------------------------
                case "-u": {
                    SimpleDateFormat myDate = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    synchronized (allPeople) {
                        for (int i = 1, l = args.length; i < l; ) {

                            try {
                                 String str = args[i+3];
                                date = myDate.parse(str);
                            }
                           catch (Exception e){

                           }

                            int index = Integer.parseInt(args[i]);
                            allPeople.get(index).setName(args[++i]);

                            if (args[++i].equals("м")) allPeople.get(index).setSex(Sex.MALE);
                            else allPeople.get(index).setSex(Sex.FEMALE);

                            allPeople.get(index).setBirthDate(date);
                            i+=2;
                        }
                        break;
                    }
                }
                //----------------------------
                case "-d": {
                    synchronized (allPeople){
                    try {

                        for (int i = 1, l = args.length; i < l; i++) {
                            System.out.println(Integer.parseInt(args[i]));
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setName(null);

                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Нет такого индекса для удаления");
                    }
                    break;
                }
                }
                case "-i": {
                    synchronized (allPeople){
                    SimpleDateFormat myDataFormater = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);

                    try {
                        for (int i = 1, l = args.length; i < l; i++) {
                            String s = allPeople.get(Integer.parseInt(args[i])).getName() + " ";
                            if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)) s = s + "ж ";
                            else s = s + "м ";
                            s = s + myDataFormater.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate());
                            System.out.println(s);

                        }
                    } catch (IndexOutOfBoundsException | NullPointerException e) {
                        System.out.println("Нет такого индекса для просмотра");
                    }
                }
                break;

            }//start here - начни тут
        }
    }

}
