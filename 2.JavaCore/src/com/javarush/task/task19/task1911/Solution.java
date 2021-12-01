package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;/*
Ридер обертка
*/
import java.io.UnsupportedEncodingException;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws UnsupportedEncodingException {

        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream steam = new PrintStream(byteArrayOutputStream);
        System.setOut(steam);

        testString.printSomething();

        String str = byteArrayOutputStream.toString("utf-8");
        System.setOut(console);

        System.out.println(str.toUpperCase());



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
