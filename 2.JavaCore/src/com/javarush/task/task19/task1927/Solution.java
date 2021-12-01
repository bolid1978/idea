package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream steam = new PrintStream(byteArrayOutputStream);
        System.setOut(steam);

        testString.printSomething();
        String str = byteArrayOutputStream.toString();
        System.setOut(console);


       // System.out.println(str);
        String [] s = str.split("\n");
        String a ="JavaRush - курсы Java онлайн";
      //  System.out.println(Arrays.toString(s));
        for (int i = 0 , l = s.length; i < l; i++) {
            System.out.println(s[i]);

            if ((i+1)%2 == 0) System.out.println(a);

        }




    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
