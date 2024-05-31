package com.java.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public static void main(String[] args) {
        boolean res = isPossible(new int[]{2,1000000000});
        System.out.println(res);
    }


    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = target.length;
        long sum = 0;

        for (int v : target) {
            maxHeap.offer(v);
            sum += v;
        }

        while (true) {

            int max = maxHeap.poll();
            long rest = sum - max;


            // base case
            if (max == 1 || rest == 1) return true;

            // impossible cases
            if (rest == 0 || max <= rest) return false;

            int prev = (int)(max % rest);

            if (prev == 0) prev = (int)rest;

            // update
            sum = prev + rest;
            maxHeap.offer(prev);

        }
    }








}
