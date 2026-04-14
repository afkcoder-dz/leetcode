package com.java.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    class MyQueue {
        Deque<Integer> stackIn;
        Deque<Integer> stackOut;

        public MyQueue() {
            stackIn = new ArrayDeque<>();
            stackOut = new ArrayDeque<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            moveIfNeeded();
            return stackOut.pop();
        }

        public int peek() {
            moveIfNeeded();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        private void moveIfNeeded() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

    }

}
