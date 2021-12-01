package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
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
       // System.out.println(map);
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        Iterator<Map.Entry<String, String>> iteratortwo = map.entrySet().iterator();
        Map.Entry<String, String> pair;
        Map.Entry<String, String> pairtwo;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListtwo = new ArrayList<>();
        ArrayList<String>  arrayListtree= new ArrayList<String>(map.values());
        System.out.println(arrayListtree);
        LinkedList<String> linkedList=new LinkedList<>();

        while (iterator.hasNext()) {

           for (Map.Entry<String,String> entry:map.entrySet()){
               pair = iterator.next();
              // arrayList.add(pair.getValue());

               linkedList.add(pair.getValue());
           }
        }
       // System.out.println(linkedList);

        //------------------------------------------------
        for (int i = 0; i < linkedList.size(); i++) {
            boolean flagcopy=true;
            for (int j = i+1; j < linkedList.size()-1; j++) {
                if(linkedList.get(i).equals(linkedList.get(j))){
                    if(flagcopy) {
                        arrayList.add(linkedList.get(i));flagcopy=false;
                    }
                    linkedList.remove(j);
                }
            }
        }
       // System.out.println(arrayList);
//-------------------------------------------------------------------
        for (String element:arrayList
             ) {
            removeItemFromMapByValue(map, element);
        }
        //-----------------------------------------

       // System.out.println(map);

    }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
        //System.out.println(map);
    }

    public static void main(String[] args) {
    //  Date start=new Date();
     // long a=start.getTime();
      removeTheFirstNameDuplicates(createMap());
    //  Date stop=new Date();
     //   System.out.println(stop.getTime()-start.getTime());
    }
}
