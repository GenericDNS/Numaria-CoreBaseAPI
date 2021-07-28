package com.generic.protocol.game.api.service;

import com.generic.Numaria;

public class Scheduler {

    int index;

    public Scheduler(int index) {
        this.index = index;
    }

    public void startScheduler(int delaySeconds) {
        Numaria.getInstance().getExecuteService().executeNewScheduleTask(new Runnable() {

            @Override
            public void run() {

                index--;

            }
        }, delaySeconds*1000);
    }

    public void listen(int listenedIndex, ExecuteOnIndex execute) {
        if (this.index == listenedIndex) execute.execute();
    }

}
