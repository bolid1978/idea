package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код т
    }

    public static class RacingClock extends Thread {
        public RacingClock() {

            start();
        }

        public void run() {
            for ( ;numSeconds >0 ; numSeconds--) {

                System.out.print(numSeconds +" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    System.out.println("Прервано!");break;
                    //e.printStackTrace();
                }

                if(numSeconds == 1 ) {
                    System.out.println("Марш!");
                    break;
                }
            }




            //add your code here - добавь код тут
        }
    }
}
