package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <E> E someStaticMethod(E one) {
        System.out.println(one);
        return one;
    }
}
