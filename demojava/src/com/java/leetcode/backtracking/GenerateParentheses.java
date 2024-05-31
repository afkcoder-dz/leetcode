package com.java.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;

        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public void backtrack(int n, int left, int right, StringBuilder stringBuilder, List<String> result) {
        if (left == n && right == n) {
            result.add(stringBuilder.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left > n) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            char c = "()".charAt(i);
            stringBuilder.append(c);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            backtrack(n, left, right, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (c == '(') {
                left--;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParenthesis2(3));
        System.out.println(test.generateParenthesis(1));
    }


        public List<String> generateParenthesis2(int n) {
            List<String> result = new ArrayList<>();
            backtrack(n, n, "", result);
            return result;
        }

        private void backtrack(int open, int close, String current, List<String> result) {
            if (open == 0 && close == 0) {
                result.add(current); // Found a valid combination
                return;
            }

            if (open > 0) {
                backtrack(open - 1, close, current + "(", result); // Add an open parenthesis
            }

            if (close > open) {
                backtrack(open, close - 1, current + ")", result); // Add a close parenthesis
            }
        }



}
