package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler,Runnable {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
      //  System.out.println(e);

          //  Throwable th = e;
            if (e != null) {
                uncaughtException(t, e.getCause());
                System.out.println(e);t.interrupt();

        }
      // e.printStackTrace();

      //  System.out.println(allExip[0]);
//        System.out.println(allExip);
//        for (StackTraceElement element:allExip
//             ) {
//            System.out.println(element);
//            String str = ele.getClass().toString();
//            str = str.replaceAll("class", "");
//            System.out.println(str + ": "+ ele.getClassName());

           // System.out.println("Сработало исключение");
   //     }

    }

    @Override
    public void run() {
        throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
    }

    public static void main(String[] args) {

            Solution solution =  new Solution();
            Thread thread = new Thread(solution);
            thread.setUncaughtExceptionHandler(solution);
            thread.start();
        }



}
