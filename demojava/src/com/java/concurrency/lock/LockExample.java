package com.java.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
   Lock VS Synchronized block

 1. Synchronized blocks must be contained with a single method.
    lock.lock() and lock.unlock() can be called from different methods.

 2. lock.lock() and lock.unlock() provides the same visibility and
    happens before guarantees as entering and exiting a synchronized block.

 3. Synchronized blocks are always reentrant. Locks can decide not to be.

 4. Synchronized blocks do not guarantee fairness. Locks can.
 */


public class LockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true); // the lock use a fair ordering policy
        int holdCount = lock.getHoldCount();
        lock.getQueueLength();
        lock.hasQueuedThread(Thread.currentThread());
        lock.hasQueuedThreads();
        lock.isFair();
        lock.isLocked();
        lock.isHeldByCurrentThread();

        try {
            lock.tryLock(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock.lock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }




}
