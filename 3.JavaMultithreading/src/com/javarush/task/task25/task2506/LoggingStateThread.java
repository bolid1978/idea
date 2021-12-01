package com.javarush.task.task25.task2506;

import java.util.ArrayList;
import java.util.List;

public class LoggingStateThread extends Thread{
        Thread thread;
    public LoggingStateThread(Thread thread) {

        this.thread = thread;
      //  setDaemon(true);
    }

    @Override
    public void run() {
        List<State> stateList = new ArrayList<>();
        while (true) {
            State state = thread.getState();
            if (!(stateList.contains(state))) System.out.println(state);
            stateList.add(state);
            if (state == State.TERMINATED) break;
        }
    }


}
