package com.java.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


    /**
     * 14 ms
     * @param nums
     * @return
     */
    public static int majorityElement0(int[] nums) {
        Map<Integer, Integer> elementCounter = new HashMap<>();
        for (int num : nums) {
            elementCounter.putIfAbsent(num, 0);
            elementCounter.computeIfPresent(num, (k, v) -> v + 1);
            if (elementCounter.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 2227ms
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        // bubble sorting
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - 1 - i; j ++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        int counter = 1;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
            }else{
                counter = 1;
            }
            if (counter > nums.length/2) {
                return nums[i];
            }
        }

        return 0;
    }


    /**
     * 2ms
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /** 1ms
     * Moore's voting algorithm
     *  Solve the problem in linear time and  O(1) space
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        {
            int count = 0;
            int majority = 0;

            for (int i = 0; i < nums.length; i++)
            {
                if (count == 0)
                {
                    majority = nums[i];
                    count++;
                }
                else if (majority != nums[i])
                {
                    count--;
                }
                else
                {
                    count++;
                }
            }

            return majority;
        }
    }



    public static void main(String[] args) {
        int[] nums1 = {6, 5, 5};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1};
       System.out.println(majorityElement0(nums1));
       System.out.println(majorityElement0(nums2));

        System.out.println(majorityElement2(nums1));
        System.out.println(majorityElement2(nums2));
        System.out.println(majorityElement2(nums3));
    }


}
