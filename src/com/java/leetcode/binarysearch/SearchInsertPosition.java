package com.java.leetcode.binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (startIndex > endIndex) {
            return startIndex;
        }
        if (nums[midIndex] > target) {
            return binarySearch(nums, startIndex, midIndex - 1, target);
        } else {
            return binarySearch(nums, midIndex + 1, endIndex, target);
        }
    }

    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return nums[mid];  // Target found
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return left; // Target not found, return the index where it should be inserted
    }


    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        System.out.println(test.searchInsert(new int[]{1, 3}, 0));
    }

}
