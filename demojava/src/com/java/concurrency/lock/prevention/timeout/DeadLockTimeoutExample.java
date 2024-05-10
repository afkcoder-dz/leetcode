package com.java.concurrency.lock.prevention.timeout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTimeoutExample {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new TimeoutRunnable1(lock1, lock2));
        Thread thread2 = new Thread(new TimeoutRunnable2(lock1, lock2));

        thread1.start();
        thread2.start();
    }






}
