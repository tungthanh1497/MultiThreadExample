package com.tungtt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 15:24
 */
public class ThreadManager implements OnTaskListener {
    private static final int NUM_OF_THREAD = 5;

    private ExecutorService mExecutorService;
    private List<BaseWorker> mPendingList;
    private List<BaseWorker> mExecutingList;

    public ThreadManager() {
        this.mExecutorService = Executors.newFixedThreadPool(NUM_OF_THREAD);
        this.mPendingList = new ArrayList<>();
        this.mExecutingList = new ArrayList<>();
    }

    public void execute(BaseWorker task) {
        task.setListener(this);
        mPendingList.add(task);
        mPendingList.sort((o1, o2) -> Integer.compare(o2.getPriority(), o1.getPriority()));
        if (mExecutingList.size() < NUM_OF_THREAD) {
            runFirstTask();
        }
    }

    @Override
    public void onTaskFinished(BaseWorker task) {
        mExecutingList.remove(task);
        if (mPendingList.size() > 0) {
            runFirstTask();
        } else if (mExecutingList.size() == 0) {
            mExecutorService.shutdown();
            while (!mExecutorService.isShutdown()) {
                System.out.println("Shutting down");
            }
            System.out.println("All tasks are finished");
        }
    }

    private void runFirstTask() {
        BaseWorker task = mPendingList.get(0);
        mExecutingList.add(task);
        mPendingList.remove(task);
        mExecutorService.execute(() -> task.run());
    }
}
