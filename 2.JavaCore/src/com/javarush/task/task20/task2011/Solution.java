package com.javarush.task.task20.task2011;

import java.io.*;

/* 
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {

            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(year);
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String)in.readObject();
           this.year = in.readInt();

           in.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apartment = new Apartment("moscow", 12);
        System.out.println(apartment.toString());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:\\1\\оne.txt"));

        apartment.writeExternal(objectOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:\\1\\one.txt"));

        Apartment aptwo = new Apartment();
        aptwo.readExternal(objectInputStream);
        System.out.println(aptwo.toString());

    }
}
