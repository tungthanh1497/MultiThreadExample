package com.tungtt;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 14:52
 */
public abstract class BaseWorker {

    private String name;
    private int priority;
    private long delayTime;
    private OnTaskListener listener;

    public BaseWorker(String name, int priority, long delayTime) {
        this.name = name;
        this.priority = priority;
        this.delayTime = delayTime;
    }

    public abstract void run();

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public OnTaskListener getListener() {
        return listener;
    }

    public void setListener(OnTaskListener listener) {
        this.listener = listener;
    }

    @Override
    public String toString() {
        return "BaseWorker{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", delayTime=" + delayTime +
                '}';
    }
}
