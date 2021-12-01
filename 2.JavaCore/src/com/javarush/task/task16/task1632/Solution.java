package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
        static {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            class oneThread implements Runnable {

                public void run() {
                    while (true) ;
                }
            }

            class  twoThread implements  Runnable{

                public void run() {
                    if(Thread.currentThread().isInterrupted())

                            System.out.println("InterruptedException");
                    }

                }


            class  freeThread implements  Runnable {

                public void run() {
                    while (true) {
                        try {

                            System.out.println("Ура");Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            class  foorThread extends Thread implements Message{


                    private volatile boolean myBoolean = true;
                    public void run() {
                        while (myBoolean) {
                        }
                    }
                    public void showWarning() {
                        myBoolean = false;
                    }


            }

            class  fiveThread implements Runnable {

                public void run() {
                    String s="";
                    int sum = 0;
                    while(true){
                        try {
                          s = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if(s.equals("N")) break;
                        else{
                          sum+=Integer.parseInt(s);
                        }

                    }
                    System.out.println(sum);
                }
            }



               threads.add( new Thread(new oneThread()));
               threads.add( new Thread(new twoThread()));
               threads.add( new Thread(new freeThread()));
               threads.add( new foorThread());
               threads.add( new Thread(new fiveThread()));





}
    public static void main(String[] args) {
          //threads.get(3).start();


         // threads.get(1).interrupt();


    }
}