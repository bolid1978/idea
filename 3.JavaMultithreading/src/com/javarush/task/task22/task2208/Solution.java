package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    static HashMap<String,String> map = new HashMap<String,String>();

    public static void main(String[] args) {

        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(map);
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        String str ="";
        StringBuilder stringBuilder = new StringBuilder(str);
        for (Map.Entry<String, String> pair :params.entrySet()
             ) {
            String param = pair.getValue();
            if(param != null){
            stringBuilder.append(pair.getKey());
            stringBuilder.append(" = '");
            stringBuilder.append(pair.getValue());
            stringBuilder.append("' and ");
            }

        }
        if(!stringBuilder.toString().equals(""))
        stringBuilder.delete(stringBuilder.length()-5, stringBuilder.length());
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
