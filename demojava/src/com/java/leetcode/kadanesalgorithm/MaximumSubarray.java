package com.java.leetcode.kadanesalgorithm;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num : nums){
            currentMax += num;
            currentMax = Math.max(currentMax, num);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}
