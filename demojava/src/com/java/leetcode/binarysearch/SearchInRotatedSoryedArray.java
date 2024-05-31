package com.java.leetcode.binarysearch;

public class SearchInRotatedSoryedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target in the left half
                } else {
                    left = mid + 1; // target in the right half
                }
            } else {
                // right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target in the right half
                } else {
                    right = mid - 1; // target in the left half
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSoryedArray searcher = new SearchInRotatedSoryedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searcher.search(nums, target)); // Output: 4
    }
}
