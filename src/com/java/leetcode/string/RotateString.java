package com.java.leetcode.string;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public boolean rotateString1(String s, String goal) {
        int n = s.length();
        if (goal.length() != n) return false;
        if (n == 1) return s.equals(goal);

        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] == goal.charAt(0)) {
                String rotatedStr = s.substring(i, n) + s.substring(0, i);
                if (rotatedStr.equals(goal)) return true;
            }
        }
        return false;
    }
}
