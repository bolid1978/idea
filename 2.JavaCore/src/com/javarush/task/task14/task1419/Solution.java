package com.javarush.task.task14.task1419;

import javax.security.auth.login.AccountExpiredException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new ArrayStoreException());
            exceptions.add(new ClassCastException ());
            exceptions.add(new IllegalArgumentException ());
            exceptions.add(new IllegalMonitorStateException ());
            exceptions.add(new NegativeArraySizeException  ());
            exceptions.add(new NullPointerException ());
            exceptions.add(new SecurityException());
            exceptions.add(new UnsupportedOperationException ());

        }

        //напишите тут ваш код

    }
}
