package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        
       /*
        list.add("Вишня");
        list.add("1");
        list.add("Боб");
        list.add("3");
        list.add("Яблоко");
        list.add("22");
        list.add("0");
        list.add("Арбуз");*/
//-----------------------------
        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        boolean [] index= index(array);
        String[] arrayString=onlyString(array);
   //     for (String element: arrayString){
    //        System.out.println(element);
     //   }
        Integer[] arrayInteger=onlyInteger(array);
     //   for (Integer element: arrayInteger){
     //       System.out.println(element);
      //  }

        // групируем интеджер по убыванию
        Arrays.sort(arrayInteger);
        Collections.reverse(Arrays.asList(arrayInteger));
     //   System.out.println(Arrays.toString(arrayInteger));
        //  групируем стрин по возрастанию
        for (int i = 0; i < arrayString.length-1; i++) {
            for (int j = i; j < arrayString.length; j++) {
                if(isGreaterThan(arrayString[i],arrayString[j])) {
                    String a=arrayString[i];arrayString[i]=arrayString[j];arrayString[j]=a;
                }

            }
        }
       // System.out.println(Arrays.toString(arrayString));
          //------------------запихиваем всё назад в массив array
        int countarrayString=0;
        int countarrayInteger=0;
        for (int i = 0; i < array.length; i++) {
            if(!index[i]) {
                array[i]=arrayString[countarrayString];
                countarrayString++;
            }else {
                array[i]=String.valueOf(arrayInteger[countarrayInteger]);
                countarrayInteger++;
            }
        }


    }

//******************************************************************************************
    //------получаеммасив толькоинтов
    public static Integer[] onlyInteger(String [] array){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])) list.add(Integer.parseInt(array[i]));
        }
        Integer[] arrayTemp = list.toArray(new Integer[0]);
        return arrayTemp;
    }
    
    
    
    //---------получаем массив только стрингов
    public static String[] onlyString(String [] array){
        ArrayList<String> list=new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            if(!isNumber(array[i])) list.add(array[i]);
        }
        String[] arrayTemp = list.toArray(new String[0]);
        return arrayTemp;
    }

    //----порядковое место строки или цыфры

    public static boolean[] index(String[] array){
        boolean[] index=new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])) {
                //------------это слово
                index[i] =true;continue;
            }
            //---------цыфра
            index[i]=false;
        }// напишите тут ваш код
        return index;
    }


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
