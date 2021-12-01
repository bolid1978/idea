package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();
        String str = string;
        String [] strMass = str.split("\\s");
        if(strMass.length < 5) throw new TooShortStringException();
        str ="";

        for (int i = 1; i < 5 ; i++) {
            str = str +(strMass[i] + " ");
        }
       str = str.trim();
        return str;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
