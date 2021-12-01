package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
       HashMap <String ,Integer> hashMap=new HashMap<String, Integer>();
       hashMap.put("Rick", 300);
       hashMap.put("Dick", 300);
       hashMap.put("Gick", 300);
       hashMap.put("Kick", 300);
       hashMap.put("Lick", 300);
       hashMap.put("Uick", 300);
       hashMap.put("Oick", 300);
       hashMap.put("Pick", 300);
       hashMap.put("Tick", 300);
       hashMap.put("Mick", 700);

        TreeMap <String ,Integer> treeMap =new TreeMap<String, Integer>();
       treeMap.putAll(hashMap);
        System.out.println(treeMap);
       return hashMap;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
     //   System.out.println(map);


            Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()) {
                Map.Entry<String, Integer> pair=iterator.next();   // получение пары элементов
                if(pair.getValue()<500){
                    map.remove(pair.getKey());
                    iterator = map.entrySet().iterator();
                }


            }


    //    System.out.println(map);
        //напишите тут ваш код
    }

    public static void main(String[] args) {

      removeItemFromMap(createMap());
    }
}