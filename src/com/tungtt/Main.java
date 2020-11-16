package com.tungtt;

import com.tungtt.tasks.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        List<BaseWorker> listWorkers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listWorkers.add(new SendRequestTask("SRT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            listWorkers.add(new UploadTask("UT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            listWorkers.add(new GetDataTask("GDT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            listWorkers.add(new InsertDataLocalTask("IDLT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            listWorkers.add(new DoActionTask("DAT" + (i + 1), random.nextInt(50)));
        }
        System.out.println(listWorkers);


        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (BaseWorker item : listWorkers) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    item.run();
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }
        System.out.println("Finished all threads");
    }
}
