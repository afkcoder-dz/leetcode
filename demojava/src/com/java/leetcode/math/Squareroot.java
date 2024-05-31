package com.java.leetcode.math;

public class Squareroot {
    public int mySqrt0(int x) {
        for (int i = 0; i <= x; i++) {
            if ((i * i) <= x && ((i + 1) * (i + 1) > x || (i + 1) * (i + 1) < 0)) {
                return i;
            }
        }
        return 0;
    }

    // use binary search
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {   // prevent overflow, mid * mid could be greater than Integer.MAX_VALUE
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Squareroot test = new Squareroot();
        System.out.println(test.mySqrt(0));
        System.out.println(test.mySqrt(2147395600));
    }
}
