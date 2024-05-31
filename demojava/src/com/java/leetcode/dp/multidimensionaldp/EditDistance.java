package com.java.leetcode.dp.multidimensionaldp;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If word1 is empty, insert all characters of word2
                } else if (j == 0) {
                    dp[i][j] = i; // If word2 is empty, remove all characters of word1
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no change needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // Delete
                            Math.min(dp[i - 1][j - 1], // Replace
                                    dp[i][j - 1])); // Insert
                }
            }
        }
        return dp[m][n];
    }

    Integer[][] dp;
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new Integer[m][n];
        return helper(word1, word2, m - 1, n - 1);
    }

    public int helper(String w1, String w2, int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != null) return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = helper(w1, w2, i - 1, j - 1);
        } else {
            int insert = helper(w1, w2, i, j - 1) + 1;
            int delete = helper(w1, w2, i - 1, j) + 1;
            int replace = helper(w1, w2, i - 1, j - 1) + 1;
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        System.out.println(test.minDistance("horse", "ros"));
        System.out.println(test.minDistance("intention", "execution"));
    }


}
