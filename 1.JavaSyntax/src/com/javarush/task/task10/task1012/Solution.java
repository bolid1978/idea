package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
           // list.add("мама");
           // list.add("объедки");
           // list.add("весело");
           // list.add("доллар");
        }
     //   System.out.println(list.toString());

        // напишите тут ваш код
         ArrayList <Character> listChar=new ArrayList<Character>();
        for (String elem:list) {
            char[] chars = elem.toCharArray();
            for (char element : chars
            ) {
                element = (Character) element;
                listChar.add(element);
            }



        }
       // System.out.println(listChar.toString());

            for(Character symbol:alphabet){

                int c= Collections.frequency(listChar, symbol);
                System.out.println(symbol+" "+c);
            }


    }
}
