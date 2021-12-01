package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {


    public static void main(String[] args) throws InterruptedException {

         TestThread TestThread= new TestThread();
        // Thread  threadTestThread = new Thread(TestThread);
        TestThread.start();
        TestThread.interrupt();
        //Add your code here - добавь код тут
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends  Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}