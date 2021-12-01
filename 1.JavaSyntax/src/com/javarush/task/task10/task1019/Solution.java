package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Функциональности маловато!
1
Мама
2
Рама
1
Мыла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id=0;
        String name;
        while(true) {
            try {
                id = Integer.parseInt(reader.readLine());
            }catch (NumberFormatException e){
                break;
            }
            name = reader.readLine();
            if(String.valueOf(id)==null) {
                break;
            }
            hashMap.put(name, id);
        }
        Iterator<Map.Entry<String, Integer>> iterator=hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> pair= iterator.next();
             id=pair.getValue();
             name= pair.getKey();

            System.out.println(id + " " + name);
        }

    }
}
