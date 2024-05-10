package com.java.concurrency.volatilex;

/**
 * Using volatile keyword is not always enough to guarantee correct concurrent behavior
 */
public class Counter {
    private volatile int count = 0;

    public boolean inc() {
        if (count == 10) {
            // 1. Two threads can execute this statement simultaneously, when count = 9
            return false;
        }
        count++;
        // 2. This is not a atomic operation
        // read of the variable
        // increment of the variable
        // write the variable to the main memory
        // when count=9, if two threads execute this method, finally count=10, not 11.
        return true;
    }


}
