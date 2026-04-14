package com.java.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElementInArray {


    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n: nums){
            minHeap.add(n);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest1(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            if(min > num)min = num;
            if(max < num) max = num;
        }

        int[] freq = new int[max - min + 1];

        for(int num : nums) {
            freq[num - min]++;
        }

        for(int i=freq.length - 1; i >= 0; i--) {
            if(freq[i] > 0) k -= freq[i];
            if(k <= 0)return min + i;
        }

        return -1;
    }


    // time limit exceeds
    public int findKthLarges0(int[] nums, int k) {
        List<Integer> maxList = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            int currentMax = Integer.MIN_VALUE;
            for (int n : numList) {
                currentMax = Math.max(currentMax, n);
            }
            numList.remove(Integer.valueOf(currentMax));
            maxList.add(currentMax);
        }
        return maxList.get(maxList.size() - 1);
    }

    public static void main(String[] args) {
        KthLargestElementInArray test = new KthLargestElementInArray();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
