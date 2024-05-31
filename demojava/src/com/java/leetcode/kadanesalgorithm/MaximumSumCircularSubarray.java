package com.java.leetcode.kadanesalgorithm;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Kadane's for maximum subarray sum
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's for minimum subarray sum
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, maxSum is the largest element
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the maximum of the non-wraparound and wraparound cases
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();
        int[] nums = {5, -3, 5};
        System.out.println(solution.maxSubarraySumCircular(nums)); // Output: 10
    }
}
