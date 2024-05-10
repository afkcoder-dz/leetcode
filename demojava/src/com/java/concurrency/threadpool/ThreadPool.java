package com.java.concurrency.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    public BlockingQueue<Runnable> taskQueue;
    public List<ExecutingRunnable> executors;
    public boolean isStopped;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        executors = new ArrayList<>(noOfThreads);
        for (int i = 0; i < noOfThreads; i++) {
            ExecutingRunnable executor = new ExecutingRunnable(taskQueue);
            executors.add(executor);
        }
        for (ExecutingRunnable executingRunnable : executors) {
            new Thread(executingRunnable).start();
        }
    }

    public void execute(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("Thread pool is stopped");
        }
        this.taskQueue.offer(task);
    }


    public synchronized void stop() {
        this.isStopped = true;
        for (ExecutingRunnable executingRunnable : executors) {
            executingRunnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        // Todo Issue here: task queue is empty does not mean task has been finished
        // Bellow is not correct
       // while(executors.stream().noneMatch(executingRunnable -> executingRunnable.thread.isAlive())){
       while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
