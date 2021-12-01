package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        Reader in =new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(in);

        ArrayList<String> lictString=new ArrayList<>();
        lictString.add(bufferedReader.readLine());
        lictString.add(bufferedReader.readLine());
        lictString.add(bufferedReader.readLine());
        lictString.add(bufferedReader.readLine());
        lictString.add(bufferedReader.readLine());

        int min=lictString.get(0).length();
        for (int i = 1; i < lictString.size(); i++) {
            if(min>lictString.get(i).length()) min=lictString.get(i).length();
        }
        for (int i = 0; i <lictString.size() ; i++) {
            if(lictString.get(i).length()==min) System.out.println(lictString.get(i));
        }
        //напишите тут ваш код
    }
}
