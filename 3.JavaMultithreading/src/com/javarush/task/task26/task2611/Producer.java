package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
    int count = 0;
    @Override
    public void run() {
        try {
            while(true) {

                count++;
                String str = "Some text for " + count;
                map.put(Integer.toString(count), str);
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }

    }
}
