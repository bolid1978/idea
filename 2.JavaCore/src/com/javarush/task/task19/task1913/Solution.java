package com.javarush.task.task19.task1913;

/*
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out; // настоящий принт стим что бы потом его вернуть

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream steam = new PrintStream(byteArrayOutputStream);
        System.setOut(steam);         // что бы сиситема подменяла выходной поток на наш то есть поток байт она все положет в поток байт а не в консоль
        testString.printSomething();  // положили строку в поток байт
        String str = byteArrayOutputStream.toString();
        str = str.replaceAll("[^\\d]","");
        System.setOut(console);
        System.out.println(str);




    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
