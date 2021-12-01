package com.javarush.task.task19.task1904;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("c:\\1\\one.txt"),"windows-1251" );
        Person person ;
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        person = personScannerAdapter.read();
        personScannerAdapter.close();

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
           // fileScanner.nextLine();
            String lastName = fileScanner.next();
            String firsName = fileScanner.next();
            String middleName = fileScanner.next();

            int day = fileScanner.nextInt();
           // System.out.println(day);

            int month = fileScanner.nextInt();
          //  System.out.println(month);
            int year = fileScanner.nextInt();
          //  System.out.println(year);

            Date birthDate =  new Date(year-1900, month-1, day);

           Person person = new Person(firsName, middleName, lastName, birthDate);
          // System.out.println(person);



            return person;
        }

        @Override
        public void close() throws IOException {
           fileScanner.close();

        }
    }
}
