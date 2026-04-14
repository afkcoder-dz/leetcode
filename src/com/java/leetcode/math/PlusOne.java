package com.java.leetcode.math;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] < 10) {
                return digits;   // No carry, return the result
            }
            // carry = 1, reset this digit to 0
            digits[i] = 0;
        }

        // if we exit the loop, it means we have a carry for all the digits (e.g.,999+1)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        System.out.println(Arrays.toString(test.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(test.plusOne(new int[]{4, 3, 2,1})));
        System.out.println(Arrays.toString(test.plusOne(new int[]{9})));
    }
}
