package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException,InterruptedException {

        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{

        String one,two,free;
        public void run() {
            try {
                  one = reader.readLine();
                  two = reader.readLine();
                  free = reader.readLine();
            }
               catch (IOException e){

               }


        }

        public void printResult(){
            System.out.println(one + " "+ two + " " + free + " ");
        }
    }
    //add your code here - добавьте код тут
}
