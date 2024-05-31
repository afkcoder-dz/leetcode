package com.java.leetcode.dp;

import java.util.*;

public class WordBreak {

    // Dynamic programming
    // Time Complexity:O(n^2), where n is the length of s
    // Space complexity: O(n)

    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null) return false;
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // s.subString endIndex is exclusive
        dp[0] = true; // Base case
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }
        return dp[n];
    }

    // Backtracking, DFS with Memoization
    // Time complexity O(n*m), m: Number of words in wordDict.
    // Space complexity O(n): For the memo array and recursion stack

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        Boolean[] memo = new Boolean[s.length() + 1]; // memo[i]=true means the substring s[i:] can be segmented into words from wordDict.
        return wordBreakHelper(s, 0, wordDict, memo);
    }

    private boolean wordBreakHelper(String s, int index, List<String> wordDict, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) return memo[index];

        for (String word : wordDict) {
            if (s.startsWith(word, index) && wordBreakHelper(s, index + word.length(), wordDict, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }


    // Another backtracking, DFS with Memoization
    // Time Complexity: O(n^2), as each substring s[start:end] is considered once.
    // Space Complexity: O(n) for the memo table and recursion stack.

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private boolean dfs(String s, int start, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (start == s.length()) return true; // Reached the end
        if (memo.containsKey(start)) return memo.get(start);

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && dfs(s, end, wordSet, memo)) {
                memo.put(start, true);
                return true;
            }
        }

        memo.put(start, false);
        return false;
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak("aaaaaaa", List.of("aaaa", "aaa")));
        System.out.println(test.wordBreak2("applepenapple", List.of("apple", "pen")));
        System.out.println(test.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
