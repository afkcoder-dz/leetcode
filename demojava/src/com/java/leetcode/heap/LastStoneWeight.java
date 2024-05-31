package com.java.leetcode.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] test = new int[]{7, 6, 7, 6, 9};
        System.out.println(lastStoneWeight(test));
    }

    public static int lastStoneWeight(int[] stones) {
        int[] count = new int[1001];

        for (int s : stones) {
            count[s]++;
        }

        int cur = 1000;

        while (cur > 0) {
            if (count[cur] == 0) {
                cur--;
                continue;
            }

            // If we have at least two stones of same weight
            if (count[cur] >= 2) {
                count[cur] -= 2;
            } else {
                // One stone left, find next smaller stone
                int next = cur - 1;

                while (next > 0 && count[next] == 0) {
                    next--;
                }

                // No other stone exists
                if (next == 0) {
                    return cur;
                }

                // Smash cur and next
                count[cur]--;
                count[next]--;
                count[cur - next]++;
            }
        }

        return 0;
    }


    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int s : stones) {
            maxHeap.offer(s);


        }

        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}