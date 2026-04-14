package com.java.leetcode.dp.multidimensionaldp;

public class LongestPalindromicSubstring {

    public String longestPalindrome0(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = s.substring(i, i + 1);
        }
        String longestPalindrome = dp[0][0];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = String.valueOf(s.charAt(i)) + s.charAt(j);
                    } else if (!dp[i + 1][j - 1].equals("*")) {
                        dp[i][j] = s.charAt(i) + dp[i + 1][j - 1] + s.charAt(j);
                    } else {
                        dp[i][j] = "*";
                    }
                } else {
                    dp[i][j] = "*";
                }


                if (dp[i][j].length() > longestPalindrome.length()) {
                    longestPalindrome = dp[i][j];
                }
            }
        }
        return longestPalindrome;
    }

    // time complexity O(n^2), space complexity O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    // time complexity O(n^2), space complexity O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // Odd length palindrome
            int len2 = expandFromCenter(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }


    public String longestPalindrome3(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("aaaaa"));
        System.out.println(test.longestPalindrome("ac"));
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
    }
}
