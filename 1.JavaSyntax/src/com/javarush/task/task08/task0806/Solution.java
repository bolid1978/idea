package com.javarush.task.task08.task0806;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Коллекция Map из Object
*/

public class Solution {
    public static void main(String[] args) {
      //  sun.misc.Unsafe f=sun.misc.Unsafe.getUnsafe();
        int a=12;
      //  System.out.println(f.getAddress(a));
        Map<String, Object> map = new HashMap<>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);


        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));

        map.put("Gevey", '6');



        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);
       // System.out.println(f.getAddress((Long) map.get("Hugs")));
        System.out.println(map.get("Sim").hashCode());
        System.out.println(map.get("Arbus").hashCode());
        System.out.println(map.get("Cat").hashCode());


        Iterator <Map.Entry<String,Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> pair = iterator.next();
            System.out.println(pair.getKey()+" - "+pair.getValue());

            //System.out.println(iterator.next().getKey()+" - "+iterator.next().getValue());
        }
        /*
        for (Map.Entry<String, Object> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Object value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
        }*/
        //напишите тут ваш код

    }
}
