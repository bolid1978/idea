package com.javarush.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {
    Class <T> my ;

    public Generator(Class<T> e) {
        my = e;
    }

    T newInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T one = my.getConstructor().newInstance();
        return  one;
    }
}
