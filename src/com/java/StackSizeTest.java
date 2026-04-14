package com.java;

public class StackSizeTest {
    private static int depth = 0;

    public static void main(String[] args) {
        try {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("Maximum recursion depth: " + depth);
        }
    }

    private static void recurse() {
        depth++;
        recurse(); // Recursive call
    }
}
