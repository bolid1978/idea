package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {


    public   static  class  SubSolution implements Externalizable{
        public SubSolution(){}




        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            throw new NotSerializableException();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }

    }

    public static void main(String[] args) throws IOException {
        SubSolution s = new SubSolution();
        try(ObjectOutputStream ofs = new ObjectOutputStream(new FileOutputStream("c:\\1\\one.bin"))){
            ofs.writeObject(s);
        }
            catch(NotSerializableException | FileNotFoundException ex)
        {
            System.out.println("Cthbfkbpfwbz yt ghjikf");
        }
    }


}
