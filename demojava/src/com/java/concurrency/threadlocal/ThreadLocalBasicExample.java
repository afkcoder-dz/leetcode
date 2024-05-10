package com.java.concurrency.threadlocal;

public class ThreadLocalBasicExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread myThread1 = new Thread(() ->{
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get());
        });

        Thread myThread2 = new Thread(() ->{
            threadLocal.set("Thread 2");
            System.out.println(threadLocal.get());
        });

        myThread1.start();
        myThread2.start();
    }

    // Multiple threads write its own value into one threadlocal variable,
    // they will not get overwritten by each other.


}
