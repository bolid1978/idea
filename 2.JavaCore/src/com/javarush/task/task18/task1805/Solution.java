package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       //  String str = "c:\\1\\one.txt";
        String str = bufferedReader.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
      //  List<ArrayList<Integer>> freq = new ArrayList<>();

        FileInputStream file = new FileInputStream(str);
        while(file.available()>0){
            arrayList.add(file.read());
        }
        file.close();
      //  System.out.println(arrayList);
        Collections.sort(arrayList);

      //  System.out.println(arrayList);
       // List myList = mySet.stream().collect(Collectors.toList())
         Set<Integer> set = new HashSet<>(arrayList);

         ArrayList<Integer> temp = new ArrayList<Integer>(set);
        Collections.sort(temp);
        for (Integer element:temp
             ) {
            System.out.print(element + " ");
        }
        System.out.println();


    }
}
