package com.tungtt.tasks;

import com.tungtt.BaseWorker;
import com.tungtt.Constants;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 14:54
 */
public class DoActionTask extends BaseWorker {

    public DoActionTask(String name, int priority) {
        super(name, priority, Constants.DELAY_TIME.DO_ACTION);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - {" +
                "priority=" + super.getPriority() +
                ", name='" + super.getName() +
                ", delayTime=" + super.getDelayTime() +
                "} - DoActionTask");
        delay(super.getDelayTime());
        if (getListener() != null) {
            getListener().onTaskFinished(this);
        }
    }

    private void delay(long delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
