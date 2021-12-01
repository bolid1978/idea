package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws  TooShortStringException {

        String  str = string;

        if(str == null) throw new TooShortStringException();
        int oneIndex = -1;
        oneIndex = str.indexOf("\t");
        if(oneIndex == -1) throw new TooShortStringException();
        str = str.substring(oneIndex+1);
        oneIndex = -1;
      //  System.out.println(str);
        oneIndex = str.indexOf("\t");
        if(oneIndex == -1) throw new TooShortStringException();
        str = str.substring(0,oneIndex);
      //  System.out.println(str);

        return str;
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        try {
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }
        catch (TooShortStringException ex){
            System.out.println("ошибка");
        }
    }
}
