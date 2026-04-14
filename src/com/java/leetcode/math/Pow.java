package com.java.leetcode.math;

public class Pow {
    int count = 0;

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        if( n % 2 == 0 ){
            return half * half;
        } else {
            return n > 0 ? half * half * x : half * half * 1 / x;
        }
    }

    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(test.myPow(2.00000, 10));
        System.out.println(test.myPow(2.10000, 3));
        System.out.println(test.myPow(34.00515, -3));
    }

}
