package com.java.leetcode.binarysearch;

public class FindPeakElement {

    /*
     *   nums[i] != nums[i + 1] for all valid i.
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            // Check the direction of the slope
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // Peak is on the right
            } else {
                right = mid; // Peak is on the left, including mid
            }
        }
        return left;  // `left` and `right` converge to a peak element
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.findPeakElement(nums)); // Output: 2 (index of peak 3)

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(solution.findPeakElement(nums2)); // Output: 5 or 1 (index of a peak)
    }
}
