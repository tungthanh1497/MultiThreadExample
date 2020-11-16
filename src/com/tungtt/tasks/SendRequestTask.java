package com.tungtt.tasks;

import com.tungtt.BaseWorker;
import com.tungtt.Constants;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 14:54
 */
public class SendRequestTask extends BaseWorker {

    public SendRequestTask(String name, int priority) {
        super(name, priority, Constants.DELAY_TIME.SEND_REQUEST);
    }

    @Override
    public void run() {
        System.out.println("SendRequestTask={" +
                "priority=" + super.getPriority() +
                ", name='" + super.getName() +
                ", delayTime=" + super.getDelayTime() +
                '}');
    }

}
