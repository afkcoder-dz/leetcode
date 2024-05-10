package com.java.concurrency.memory;

public class MyRunnable implements Runnable {
    private int count = 0;

    @Override
    public void run() {
      for(int i =0; i< 10000; i++) {
          synchronized (this) {
              count++;
          }
      }
      System.out.println(Thread.currentThread().getName() + " : " + count);
    }
}
