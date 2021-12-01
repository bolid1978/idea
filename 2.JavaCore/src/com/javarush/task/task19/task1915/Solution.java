package com.javarush.task.task19.task1915;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();


        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      //  testString.printSomething();

        PrintStream steam = new PrintStream(byteArrayOutputStream);
        System.setOut(steam);
        testString.printSomething();
        byte[] s = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOut = new FileOutputStream(str);
        fileOut.write(s);
        fileOut.close();
        System.setOut(console);
        String string = byteArrayOutputStream.toString();
        System.out.println(string);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

