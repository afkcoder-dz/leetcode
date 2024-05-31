package com.java.leetcode.math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        int original = x;
        int temp;
        if (x < 0) return false;
        while (x > 0) {
            temp = x % 10;
            reversed = reversed * 10 + temp;
            x = x / 10;
        }
        return reversed == original;
    }

    public boolean isPalindrome0(int x) {
        String xs = "" + x;

        StringBuilder sb = new StringBuilder(xs);
        String reversedString = sb.reverse().toString();

        return xs.equals(reversedString);
    }

    public boolean isPalindrome1(int x) {
        String xString = String.valueOf(x);
        int length = 0;
        if (x < 0) return false;
        if (x == 0) return true;

        while (x > 0) {
            x = x / 10;
            length++;
        }


        for (int i = 0; i < length / 2; i++) {
            if (xString.charAt(i) != xString.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(-121));
        System.out.println(test.isPalindrome(10));
    }
}
