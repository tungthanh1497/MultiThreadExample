package com.tungtt;

import com.tungtt.tasks.*;

import java.util.Random;

public class Main {

    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        ThreadManager threadManager = new ThreadManager();
        for (int i = 0; i < 50; i++) {
            threadManager.execute(generateNewTask(i + 1));
        }

    }

    private static <T extends BaseWorker> T generateNewTask(int index) {
        switch (random.nextInt(5)) {
            case 1:
                return (T) new UploadTask("UT" + index, random.nextInt(50));
            case 2:
                return (T) new GetDataTask("GDT" + index, random.nextInt(50));
            case 3:
                return (T) new InsertDataLocalTask("IDLT" + index, random.nextInt(50));
            case 4:
                return (T) new DoActionTask("DAT" + index, random.nextInt(50));
            case 0:
            default:
                return (T) new SendRequestTask("SRT" + index, random.nextInt(50));
        }
    }
}
