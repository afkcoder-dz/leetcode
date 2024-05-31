package com.java.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    // Dynamic programing O(n^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize all elements to 1

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


    // greedy + binary search
    // Time Complexity:
    // The binary search operation for each element is O(logn).
    // With n elements in the input array, the overall time complexity is O(nlogn).
    // Space Complexity: The algorithm uses O(n) additional space for the dp array.

    public int lengthOfLIS2(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int pos = binarySearch(sub, num);
            if (pos < sub.size()) {
                sub.set(pos, num);
            } else {
                sub.add(num);
            }
        }

        return sub.size();
    }

    private int binarySearch(List<Integer> sub, int target) {
        int left = 0, right = sub.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sub.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int lengthOfLIS3(int[] nums) {
        // Array to store the smallest end element of all increasing subsequences
        // of different lengths
        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            // Use binary search to find the index where this number can replace
            // an existing element or extend the subsequence
            int index = Arrays.binarySearch(dp, 0, length, num);

            // If num is not found, Arrays.binarySearch returns (-(insertion point) - 1)
            if (index < 0) {
                index = -(index + 1);
            }

            // Place num in the correct position
            dp[index] = num;

            // If num is added at the end, increment the length
            if (index == length) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        System.out.println(test.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(test.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(test.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }


    // Time Complexity: O(n^2)  Space Complexity: O(n^2)
    public List<List<Integer>> findAllLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        // Step 1: Compute the lengths of LIS ending at each index
        int[] lengths = new int[n]; // lengths[i] is the length of LIS ending at nums[i]
        List<List<Integer>>[] paths = new List[n]; // paths[i] stores all LIS paths ending at nums[i]

        int maxLen = 0; // Track the maximum LIS length

        for (int i = 0; i < n; i++) {
            lengths[i] = 1; // Every element is an LIS of length 1 by itself
            paths[i] = new ArrayList<>();
            paths[i].add(List.of(nums[i])); // Start each path with the current number

            // Check all previous elements
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // If we can extend LIS ending at nums[j]
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        paths[i] = new ArrayList<>(); // Reset paths[i]
                    }
                    if (lengths[j] + 1 == lengths[i]) {
                        // Add all paths from paths[j] extended by nums[i]
                        for (List<Integer> path : paths[j]) {
                            List<Integer> newPath = new ArrayList<>(path);
                            newPath.add(nums[i]);
                            paths[i].add(newPath);
                        }
                    }
                }
            }

            // Track the maximum LIS length
            maxLen = Math.max(maxLen, lengths[i]);
        }

        // Step 2: Collect all LIS paths of the maximum length
        List<List<Integer>> allLIS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLen) {
                allLIS.addAll(paths[i]);
            }
        }

        return allLIS;
    }


}
