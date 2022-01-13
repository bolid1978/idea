package com.javarush.task.task36.task3602;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class<?> clazz : classes){
            if (isImplementingList(clazz) && Modifier.isStatic(clazz.getModifiers()) && Modifier.isPrivate(clazz.getModifiers())){
                try {
                    Method method = clazz.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.invoke(constructor.newInstance(), 0);
                }
                catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {}
                catch (InvocationTargetException e){
                    if (e.getCause().toString().contains("IndexOutOfBoundsException")) return clazz;
                }
            }

        }
        return null;
    }

    public static boolean isImplementingList(Class<?> clazz) {
        ArrayList<Class<?>> classInterfaces = new ArrayList<>(Arrays.asList(clazz.getInterfaces()));
        ArrayList<Class<?>> parentInterfaces = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getInterfaces()));
        return classInterfaces.contains(List.class) || parentInterfaces.contains(List.class);
    }
}
