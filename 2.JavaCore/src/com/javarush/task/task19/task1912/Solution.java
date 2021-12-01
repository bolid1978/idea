package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;/*
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream steam = new PrintStream(byteArrayOutputStream);
        System.setOut(steam);
        testString.printSomething();

        String str = byteArrayOutputStream.toString();
        str = str.replaceAll("te", "??");
        System.setOut(console);
        System.out.println(str);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
