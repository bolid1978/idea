package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String pathE = e.getClass().getSimpleName();
        return String.format(string, pathE, e.getCause().toString(), t.getName());
    }
    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
            String pathE = e.getClass().getSimpleName();
            return String.format(string, e.getCause().toString(), pathE, t.getName());
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
             String pathE = e.getClass().getSimpleName();
            return String.format(string, t.getName(), pathE, e.getCause().toString());
    }
}

