package com.java.leetcode.math;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public int trailingZeroes0(int n) {
        int result = 0;
        while(n > 0){
           result += n/5;
           n = n/5;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialTrailingZeros test = new FactorialTrailingZeros();
        System.out.println(test.trailingZeroes(3));
        System.out.println(test.trailingZeroes(5));
        System.out.println(test.trailingZeroes(30));
    }

}
