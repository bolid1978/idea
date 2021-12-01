package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        HashMap<String,String> map=new HashMap<>();//напишите тут ваш код
        map.put("Николаев", "Сергей");
        map.put("Сазонов", "Дмитрий");
        map.put("Симонов", "Андрей");
        map.put("Семенов", "Андрей");
        map.put("Слепаков", "Виктор");
        map.put("Соломин", "Ренат");
        map.put("Яшин", "Ренат");
        map.put("Измайлов", "Ренат");
        map.put("Осмаловский", "Ренат");
        map.put("Федотов", "Ренат");


      //  System.out.println(map);
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int counter=0;
        for (Map.Entry<String,String> element: map.entrySet()){
            if (element.getValue().equals(name)) counter++;
        }//напишите тут ваш код
       // System.out.println(counter);
        return counter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int counter=0;
        for (Map.Entry<String,String> element: map.entrySet()){
            if (element.getKey().equals(lastName)) counter++;
        }//напишите тут ваш код
      //  System.out.println(counter);
        return counter;
    }

    public static void main(String[] args) {

        getCountTheSameFirstName(createMap(),"Андрей");
        getCountTheSameLastName(createMap(),"Николаев" );
    }
}
