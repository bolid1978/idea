package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/

public class Solution implements Serializable{

    public static class A {

        public A(){

        }



         public A(String nameA) {
            this.nameA += nameA;
        }
        transient    protected String nameA = "A";



    }

    public  class B extends A implements Serializable {

        private String nameB;

        public B() {
        }

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(nameA);


        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            nameA = (String) in.readObject();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      //  File outFile = new File("c:\\1\\one.txt");
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
        Solution solution = new Solution();
       // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\1\\one.txt"));

        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);
        oos.writeObject(b);
        oos.close();

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
     //ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\1\\one.txt"));


           B b1 = (B) ois.readObject();



        ois.close();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);

    }
}
