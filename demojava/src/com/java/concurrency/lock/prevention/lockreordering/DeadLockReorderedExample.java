package com.java.concurrency.lock.prevention.lockreordering;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Deadlock conditions:
 * 1) mutual exclusion
 * 2) No preemption
 * 3) Hold and wait
 * 4) Circular wait
 */
public class DeadLockReorderedExample {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable1(lock1, lock2));
        Thread thread2 = new Thread(new Runnable2(lock1, lock2));

        thread1.start();
        thread2.start();
    }


}
