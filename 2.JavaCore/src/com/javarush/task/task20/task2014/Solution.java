package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(new Solution(4));

        OutputStream outputStream = new FileOutputStream("c:\\1\\one.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        InputStream inputStream = new FileInputStream("c:\\1\\one.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Solution savedObject = new Solution(5);
        objectOutputStream.writeObject(savedObject);

        Solution loadedObject = new Solution(67);
        loadedObject = (Solution)objectInputStream.readObject();

        System.out.println(savedObject.string.equals(loadedObject.string));



    }

   transient private final String pattern = "dd MMMM yyyy, EEEE";
   transient private Date currentDate;
   transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
