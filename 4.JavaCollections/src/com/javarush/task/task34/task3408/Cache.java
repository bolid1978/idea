package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
         V temp = cache.get(key);
         if(temp == null){
             Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
             V object = constructor.newInstance(key);
             cache.put(key, object);
         }
        //TODO add your code here
        return temp;
    }

    public boolean put(V obj)  {
        int size = size();
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K keyReflected = (K) method.invoke(obj);
            cache.put(keyReflected, obj);
            //TODO add your code here
            return size() > size;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
