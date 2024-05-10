package com.java.concurrency.threadpool;

import java.util.concurrent.BlockingQueue;

public class ExecutingRunnable implements Runnable {
    public Thread thread;

    public BlockingQueue<Runnable> taskQueue;

    public boolean isStopped;

    public ExecutingRunnable(BlockingQueue<Runnable> taskQueue) {
        this.thread = null;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped) {
            try {
                Runnable task = taskQueue.take();
                task.run();
            } catch (Exception e) {

            }
        }
    }


    public synchronized void doStop() {
        this.isStopped = true;
        this.thread.interrupt();
    }
}
