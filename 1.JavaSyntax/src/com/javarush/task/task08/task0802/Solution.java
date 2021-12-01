package com.javarush.task.task08.task0802;

import java.util.HashMap;
import java.util.Map;

/* 
Map из 10 пар
банан - трава,
вишня - ягода,
груша - фрукт,
дыня - овощ,
ежевика - куст,
жень-шень - корень,
земляника - ягода,
ирис - цветок,
картофель - клубень
*/

public class Solution {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();//напишите тут ваш код

        //Iterator <Map.Entry<String,String>> iterator=map.entrySet().iterator();

        map.put("арбуз","ягода");
        map.put("банан","трава");
        map.put("вишня","ягода");
        map.put("груша","фрукт");
        map.put("дыня","овощ");
        map.put("ежевика","куст");
        map.put("жень-шень","корень");
        map.put("земляника","ягода");
        map.put("картофель","клубень");
        map.put("ирис","цветок");
        map.put("картофель","клубень");
        map.put("карто","клубень");
       // Iterator <Map.Entry<String,String>> iterator=map.entrySet().iterator();


        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }


    }
}
