package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    Thread thread  = new Thread();
    @Override
    public void run() {
        try {
          //  System.out.println("запуск");
            System.out.println(thread.getName());
            while(true) {

                if(thread.isInterrupted()) break;
                 Thread.sleep(100);
                System.out.println(thread.getName());
            }


        } catch (InterruptedException e) {
          //  System.out.println("ghthsdfybt");
           thread.interrupt();
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);

        thread.start();

    }

    @Override
    public void stop() {
      //  System.out.println("метод стоп");
       this.thread.interrupt();

    }
}
