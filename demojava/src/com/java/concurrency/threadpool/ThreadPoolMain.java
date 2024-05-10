package com.java.concurrency.threadpool;

public class ThreadPoolMain {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {
            int taskNo = i;

            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + " runs task: " + taskNo;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
