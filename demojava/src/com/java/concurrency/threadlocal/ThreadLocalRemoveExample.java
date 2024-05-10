package com.java.concurrency.threadlocal;

import com.java.concurrency.ThreadUtils;

public class ThreadLocalRemoveExample {

// When one thread that is using a threadlocal variable removes the value it set,
// it does not remove the values set by other threads;
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread myThread1 = new Thread(() -> {
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get());

            threadLocal.remove();
            System.out.println(threadLocal.get());

        });

        Thread myThread2 = new Thread(() -> {
            threadLocal.set("Thread 2");
            System.out.println(threadLocal.get());

            ThreadUtils.sleep(2000);
            System.out.println(threadLocal.get());

            threadLocal.remove();
            System.out.println(threadLocal.get());
        });

        myThread1.start();
        myThread2.start();
    }


}
