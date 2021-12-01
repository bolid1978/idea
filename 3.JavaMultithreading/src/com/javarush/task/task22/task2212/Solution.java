package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.io.*;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null) return  false;
        if(telNumber.matches("\\+\\d+")) return true;
        if(telNumber.matches("\\+\\d{2}\\(\\d{3}\\)\\d{7}")) return true;
        if(telNumber.matches("\\+\\d{8}\\-\\d\\d\\-\\d\\d")) return true;
        if(telNumber.matches("\\d{6}\\-\\d{4}")) return true;
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));

        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("c:\\1\\1.txt"));
        System.out.println(inputStreamReader.getEncoding());

    }
}
