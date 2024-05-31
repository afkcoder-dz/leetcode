package com.java.leetcode.bitmanipulation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Update 'ones' and 'twos' based on the current number
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones; // 'ones' will contain the single number
    }

    public static void main(String[] args) {
        SingleNumberII test = new SingleNumberII();
        System.out.println(test.singleNumber(new int[]{2,2,3,2}));
        System.out.println(test.singleNumber(new int[]{0,1,0,1,99}));
    }
}
