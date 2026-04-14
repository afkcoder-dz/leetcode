package com.java.leetcode.binarysearch;

public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half or at mid
                right = mid;
            }
        }

        // Left and right converge to the minimum element
        return nums[left];
    }


    public int findMin0(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
               if(mid == 0) return Math.min(nums[1], nums[0]);
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    if (nums[mid] <= nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
        }
        return nums[0];
    }



    public static void main(String[] args) {
        FindMinimumInRotatedArray test = new FindMinimumInRotatedArray();
//        System.out.println(test.findMin(new int[]{3,4,5,1,2}));
//        System.out.println(test.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
//        System.out.println(test.findMin(new int[]{11,13,15,17}));
        System.out.println(test.findMin(new int[]{2,1}));
    }


}
