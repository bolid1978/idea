package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static<T> ArrayList <T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> temp = new ArrayList<T>();
        Collections.addAll(temp, elements);

        return temp;
    }

    public static <T> HashSet <T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> temp = new HashSet<T>();
        Collections.addAll(temp,elements);
        return temp;
    }

    public static <K,V>HashMap <K,V>newHashMap(List<? extends K > keys, List<? extends V> values) {
        //напишите тут ваш код
        if(keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap<K,V> temp = new HashMap<K,V>();

        for (int i = 0; i < keys.size(); i++) {
            temp.put(keys.get(i), values.get(i));
        }



        return temp;
    }
}
