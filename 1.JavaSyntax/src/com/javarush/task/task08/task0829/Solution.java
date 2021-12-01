package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        List<String> listtwo = new ArrayList<>();

        while (true) {

            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            String city = reader.readLine();


            list.add(family);
            list.add(city);

        }

        HashMap<String,String> map=new HashMap<>();
        for (int i = 0; i <= list.size()-2; i+=2) {
            map.put(list.get(i), list.get(i+1) );
        }
        //System.out.println(map);

        // Read the house number
       // int houseNumber = Integer.parseInt(reader.readLine());
        String familyName = reader.readLine();

       // if (0 <= houseNumber && houseNumber < list.size()) {
        //    String familyName = list.get(houseNumber);
        //    System.out.println(familyName);
       // }
        System.out.println(map.get(familyName));
    }
}
