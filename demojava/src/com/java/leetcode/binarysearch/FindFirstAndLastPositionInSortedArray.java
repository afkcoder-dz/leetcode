package com.java.leetcode.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int startIndex = findFirst(nums, target);
        int endIndex = findLast(nums, target);
        return new int[]{startIndex,endIndex};
    }
    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
                index = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
                index = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionInSortedArray test = new FindFirstAndLastPositionInSortedArray();
        System.out.println(Arrays.toString(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{}, 0)));
    }

}
