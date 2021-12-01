package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {

    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
       //  this.handler = null;    //

        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String allStr = e.getMessage();
                String nameThread = t.getName();
                String replase  = "";
                for (int i = 0; i < nameThread.length(); i++) {
                    replase+="*";
                }
                allStr = allStr.replaceAll(nameThread, replase);

                System.out.println( allStr);
            }
        };



        // init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution solution =  new Solution (new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        });
        Thread thread = new Thread(solution,"r");
        thread.start();


    }



}