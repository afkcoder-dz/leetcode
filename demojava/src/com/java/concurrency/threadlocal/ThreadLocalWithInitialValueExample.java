package com.java.concurrency.threadlocal;

public class ThreadLocalWithInitialValueExample {

    // Different threads do not share the same initial value.


    public static void main(String[] args) {
        ThreadLocal<MyObject> threadLocal1 = new ThreadLocal<>() {
            @Override
            protected MyObject initialValue() {
                return new MyObject();
            }
        };

        ThreadLocal<MyObject> threadLocal2 = ThreadLocal.withInitial(MyObject::new);

        Thread myThread1 = new Thread(() -> {
            System.out.println("ThreadLocal 1 " + threadLocal1.get());
            System.out.println("ThreadLocal 2 " + threadLocal2.get());
        });

        Thread myThread2 = new Thread(() -> {
            System.out.println("ThreadLocal 1 " + threadLocal1.get());
            System.out.println("ThreadLocal 2 " + threadLocal2.get());
        });

        myThread1.start();
        myThread2.start();
    }


    private static class MyObject {
    }

}
