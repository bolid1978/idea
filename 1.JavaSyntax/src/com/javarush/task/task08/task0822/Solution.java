package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {

    public static void main(String[] args) throws Exception {




        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
         // Найти минимум тут
        return Collections.min(array);
    }

    public static List<Integer> getIntegerList() throws IOException {
        Reader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader) ;
        int count=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        count=Integer.parseInt(in.readLine());
        for (int i = 0; i < count; i++) {
             arrayList.add(Integer.parseInt(in.readLine()));
        }// Создать и заполнить список тут
        return arrayList;
    }
}
