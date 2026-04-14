package com.java.leetcode.bitmanipulation;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            if (bit == 1) count++;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits test = new NumberOf1Bits();
        System.out.println(test.hammingWeight(11));
        System.out.println(test.hammingWeight(128));
        System.out.println(test.hammingWeight(2147483645));
    }

}
