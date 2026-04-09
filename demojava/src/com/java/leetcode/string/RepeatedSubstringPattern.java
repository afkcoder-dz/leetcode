package com.java.leetcode.string;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern2("ababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        if (n == 1)
            return false;

        char start = s.charAt(0);
        char end = s.charAt(n - 1);

        for (int i = 0; i < n - 1; i++) { // i = n invalid case: the substring is the string itself

            if (s.charAt(i) == end) {
                String substring = s.substring(0, i + 1);
                int k = substring.length();

                if (n % k != 0)
                    continue;
                String copied = substring.repeat(n / k);

                if (copied.equals(s))
                    return true;
            }
        }

        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        return (s + s).substring(1, 2 * n - 1).contains(s);
    }

}
