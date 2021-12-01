package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread element:threads
             ) {
            switch (element.getState()){

                case NEW:
                {

                    element.start();
                    break;
                }
                case TIMED_WAITING:{
                    element.interrupt();
                    break;
                }
                case RUNNABLE:{
                    element.isInterrupted();
                    break;
                }
                case TERMINATED:{
                    System.out.println(element.getPriority());
                    break;
                }
                case WAITING:{
                    element.interrupt();
                    break;
                }
                case BLOCKED:{
                    element.interrupt();
                    break;
                }



            }
        }

        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
        Solution.processThreads(new Thread(),new Thread(),new Thread(),new Thread());
    }
}
