package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        Reader in=new InputStreamReader(System.in);
        BufferedReader reader =new BufferedReader(in);//напишите тут ваш код
        String str=reader.readLine();
        //String str="Мама мыла раму.";
        ArrayList<Character> glas=new ArrayList<Character>();
        ArrayList<Character> sogl=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character a=str.charAt(i);
            if (a.equals(' ')) continue;
            if(isVowel(a)){
                glas.add(a);
            }else{
                sogl.add(a);

            }
        }
        for (Character element:glas){
            System.out.print(element+" ");
        }
        System.out.println();
        for (Character element:sogl){
            System.out.print(element+" ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}