package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream steam =new PrintStream(byteArrayOutputStream);

        System.setOut(steam);
        testString.printSomething();
        String str = byteArrayOutputStream.toString();
       /* Pattern p = Pattern.compile("\\d+");
        Matcher matcher =p.matcher(str);
        int a = 0;
        int b = 0;
        while (matcher.find()){

        }*/
        str = str.replaceAll("\r\n","");
        String [] s = str.split("\\s");
        String result ="";
        System.setOut(console);
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        int ot = 0;
        switch (s[1]){
            case "+":{
                ot = a + b;
                result = str + ot;
                break;
            }
            case "-":{
                ot = a - b;
                result = str + ot;
                break;

            }
            case "*":{
                ot = a * b;
                result = str + ot;
                break;
            }


        }
      //  System.out.println(str);
     //   System.out.println(Arrays.toString(s));
        System.out.println(result);






    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

