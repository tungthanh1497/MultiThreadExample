package com.tungtt.tasks;

import com.tungtt.BaseWorker;
import com.tungtt.Constants;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 14:54
 */
public class InsertDataLocalTask extends BaseWorker {

    public InsertDataLocalTask(String name, int priority) {
        super(name, priority, Constants.DELAY_TIME.INSERT_DATA_LOCAL);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Start InsertDataLocalTask={" +
                "priority=" + super.getPriority() +
                ", name='" + super.getName() +
                ", delayTime=" + super.getDelayTime() +
                '}');
        delay(super.getDelayTime());
        System.out.println(Thread.currentThread().getName() + " - Finish InsertDataLocalTask={" +
                "priority=" + super.getPriority() +
                ", name='" + super.getName() +
                ", delayTime=" + super.getDelayTime() +
                '}');
    }

    private void delay(long delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
