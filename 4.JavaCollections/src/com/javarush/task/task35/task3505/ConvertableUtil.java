package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static Map convert(List<? extends Convertable> list) throws NoSuchMethodException {
        Map<Object, Convertable> result = new HashMap();

        for (int i = 0; i < list.size(); i++) {
            Convertable one =  list.get(i);
            result.put(one.getKey(),one);

            // Object temp = list.get(i).getClass().getMethod("getKey");
          //  System.out.println(temp);
        }

        return result;
    }
}
