package com.tungtt;

import com.tungtt.tasks.*;

import java.util.Random;

public class Main {

    private static Random random;
    private static ThreadManager threadManager;

    public static void main(String[] args) {
        random = new Random();


        threadManager = new ThreadManager();

        for (int i = 0; i < 10; i++) {
            threadManager.execute(new SendRequestTask("SRT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            threadManager.execute(new UploadTask("UT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            threadManager.execute(new GetDataTask("GDT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            threadManager.execute(new InsertDataLocalTask("IDLT" + (i + 1), random.nextInt(50)));
        }
        for (int i = 0; i < 10; i++) {
            threadManager.execute(new DoActionTask("DAT" + (i + 1), random.nextInt(50)));
        }

    }
}
