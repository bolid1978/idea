package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Арнольд", dateFormat.parse("June 1 2012"));
        map.put("Том Круз", dateFormat.parse("July 1 2012"));
        map.put("Винни Пух", dateFormat.parse("August 1 2012"));
        map.put("Брэд Пит", dateFormat.parse("MAY 1 2012"));
        map.put("Джони Дэп", dateFormat.parse("MAY 1 2012"));
        map.put("Марк Волберг", dateFormat.parse("MAY 1 2012"));
        map.put("Энтони Хопкинсе", dateFormat.parse("MAY 1 2012"));
        map.put("Ди каприо", dateFormat.parse("MAY 1 2012"));
        map.put("Скорцезе", dateFormat.parse("MAY 1 2012"));
    //    System.out.println(map);
        return map;//напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator=map.entrySet().iterator();//напишите тут ваш код
        while (iterator.hasNext()){
           Map.Entry<String ,Date> pair=iterator.next();
           if(pair.getValue().getMonth()==5||pair.getValue().getMonth()==6||pair.getValue().getMonth()==7) {
               map.remove(pair.getKey());
               iterator=map.entrySet().iterator();
           }

        }
       // System.out.println(map);
    }

    public static void main(String[] args) throws ParseException {
          removeAllSummerPeople(createMap());
    }
}
