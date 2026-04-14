package com.java.leetcode.dp.multidimensionaldp;

public class InterleavingString {
    // Time Complexity:
    // O(m×n) — We fill a DP table of size (m+1) x (n+1).m
    // Space Complexity:
    // O(m×n)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 == 0 && l2 == 0 && l3 == 0) {
            return true;
        }
        if (l3 != l1 + l2) return false;

        boolean[][] dp = new boolean[l1 + 1][l2 + 1]; // dp[i][j] is true if the first i characters of s1 and the first j characters of s2 can form the first i + j characters of s3.

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s3.substring(0, i + j).equals(s2.substring(0, j));
                } else if (j == 0) {
                    dp[i][j] = s3.substring(0, i + j).equals(s1.substring(0, i));
                } else if (s3.charAt(i + j - 1) != s1.charAt(i - 1) && s3.charAt(i + j - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
                }
            }
        }
        return dp[l1][l2];
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 == 0 && l2 == 0 && l3 == 0) {
            return true;
        }
        if (l3 != l1 + l2) return false;

        boolean[] dp = new boolean[l3 + 1]; // dp[i+j] is true if the first i characters of s1 and the first j characters of s2 can form the first i + j characters of s3.

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    dp[i + j] = true;
                } else if (i == 0) {
                    dp[i + j] = s3.substring(0, i + j).equals(s2.substring(0, j));
                } else if (j == 0) {
                    dp[i + j] = s3.substring(0, i + j).equals(s1.substring(0, i));
                } else if (s3.charAt(i + j - 1) != s1.charAt(i - 1) && s3.charAt(i + j - 1) != s2.charAt(j - 1)) {
                    dp[i + j] = false;
                } else {
                    dp[i + j] = (dp[i + j - 1] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) || (dp[i + j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
                }
            }
        }
        return dp[l3];
    }

    // time complexity: O(m×n)      Space complexity: O(m*n)
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, 0, memo);
    }

    boolean dfs(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][] memo) {
        if (index1 == s1.length() && index2 == s2.length())
            return true;

        if (memo[index1][index2] != null)
            return memo[index1][index2];

        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            if (dfs(s1, s2, s3, index1 + 1, index2, index3 + 1, memo)) {
                memo[index1][index2] = true;
                return true;
            }
        }

        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            if (dfs(s1, s2, s3, index1, index2 + 1, index3 + 1, memo)) {
                memo[index1][index2] = true;
                return true;
            }
        }

        memo[index1][index2] = false;
        return false;
    }

    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }
}
