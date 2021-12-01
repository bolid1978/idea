package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
         HashMap <String,String> map = new HashMap<>();
        map.put("Николаев", "Сергей");
        map.put("Сазонов", "Дмитрий");
        map.put("Симонов", "Андрей");
        map.put("Семенов", "Андрей");
        map.put("Слепаков", "Виктор");
        map.put("Федотов", "Ренат");
        map.put("Яшин", "Ренат");
        map.put("Измайлов", "Ренат");
        map.put("Осмаловский", "Ренат");
        map.put("Семенов", "Ренат");

        //напишите тут ваш код

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
