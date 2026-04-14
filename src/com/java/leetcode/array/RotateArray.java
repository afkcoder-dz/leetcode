package com.java.leetcode.array;

import java.util.Arrays;

/**
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */


public class RotateArray {

    /**
     *  Time limit exceeded
     * @param nums
     * @param k
     * @return
     */
    public static int[] rotate0(int[] nums, int k) {
        if(nums.length == 1) {
            return nums;
        }
        int rotateNum = k/nums.length <= 0 ? k : k % nums.length;
        for (int i = 0; i < rotateNum; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};
        int[] nums3 = {1, 2, 3};
        int k = 4;

        Arrays.stream(rotate0(nums2, k)).forEach(System.out::print);
    }


}
