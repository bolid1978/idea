package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

           out.writeObject(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readUTF();
            age = in.readInt();

            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person one = new Person("Olga", "nik", 60);
        one.setFather(new Person("Alexsandr", "Petrovich", 80));
        one.setMother(new Person("Tomara", "Grigorievna", 78));
        ArrayList<Person> we = new ArrayList<>();
        we.add(new Person("Alexsandr", "nik", 36));
        we.add(new Person("Sergey", "nik", 42));
        one.setChildren(we);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:\\1\\one.txt"));
        one.writeExternal(objectOutputStream);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:\\1\\one.txt"));

        Person two = new Person();

        two.readExternal(objectInputStream);
        objectInputStream.close();
        System.out.println(two.firstName);
        System.out.println(two.lastName);
        System.out.println(two.age);
        System.out.println(two.mother.firstName);
        System.out.println(two.mother.lastName);
        System.out.println(two.mother.age);
        System.out.println(two.children.get(0).firstName);

    }
}
