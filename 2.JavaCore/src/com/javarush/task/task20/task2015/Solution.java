package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/

public class Solution implements Serializable ,Runnable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println(speed);
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Thread thread = new Thread(this);
        thread.start();
        in.defaultReadObject();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution test = new Solution(12);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:\\1\\one.txt"));
        objectOutputStream.writeObject(test);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:\\1\\one.txt"));
        Solution test2 = (Solution) objectInputStream.readObject();
        objectInputStream.close();



    }
}
