package com.java.concurrency.lock.deadlock;

import com.java.concurrency.ThreadUtils;

import java.util.concurrent.locks.Lock;

public class Runnable2 implements Runnable {
    private final Lock lock1;
    private final Lock lock2;


    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " attempting to get lock2.");
        lock2.lock();
        System.out.println(Thread.currentThread().getName() + " locked lock2.");
        ThreadUtils.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " attempting to get lock1.");
        lock1.lock();
        System.out.println(Thread.currentThread().getName() + " locked lock1.");

        lock2.unlock();
        System.out.println(Thread.currentThread().getName() + " unlocked lock2.");
        lock1.unlock();
        System.out.println(Thread.currentThread().getName()+ " unlocked lock1.");
    }
}
