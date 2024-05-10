package com.java.concurrency.lock.prevention.timeout;

import com.java.concurrency.ThreadUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TimeoutRunnable2 implements Runnable {
    private final Lock lock1;
    private final Lock lock2;


    public TimeoutRunnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            int failureCount = 0;
            while (!tryLockBothLocks(lock1, lock2)) {
                failureCount++;
                System.err.println(threadName + " failed to lock both locks.");
                ThreadUtils.sleep(2000);
            }
            System.out.println(threadName + " succeeded to lock both locks after " + failureCount + " failed tries.");

            lock1.unlock();
            System.out.println(threadName + " unlocked lock1");
            lock2.unlock();
            System.out.println(threadName + " unlocked lock2");
        }
    }


    private boolean tryLockBothLocks(Lock lock1, Lock lock2) {
        String threadName = Thread.currentThread().getName();
        try {
            boolean lock2SuccessfullyLocked = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!lock2SuccessfullyLocked) {
                return false;
            }
        } catch (InterruptedException e) {
            System.err.println(threadName + " locking lock2 interrupted");
            return false;
        }
        System.out.println(threadName + " succeeded to lock lock2.");
        ThreadUtils.sleep(2000);

        try {
            boolean lock1SuccessfullyLocked = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if (!lock1SuccessfullyLocked) {
                lock2.unlock();
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " locking lock1 interrupted");
            return false;
        }
        System.out.println(threadName + " succeeded to lock lock1.");
        ThreadUtils.sleep(2000);
        return true;
    }
}
