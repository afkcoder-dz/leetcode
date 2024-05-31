package com.java.leetcode.dp.multidimensionaldp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    // Moving from bottom to top
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n]; // Create a DP array to store the minimum path sums
        // initialize DP with last row values
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    // from top to bottom
    public int minimumTotal0(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n]; // Create a DP array to store the minimum path sums
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            int[] dp2 = new int[n];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp2[j] = triangle.get(i).get(j) + dp[j];
                } else if (j == i) {
                    dp2[j] = triangle.get(i).get(j) + dp[j - 1];
                } else {
                    dp2[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                }
            }
            dp = dp2;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    // DFS
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return compute(triangle, dp, 0, 0, n);
    }

    public int compute(List<List<Integer>> triangle, Integer[][] dp, int row, int col, int n) {
        if (dp[row][col] != null)
            return dp[row][col];
        int path = triangle.get(row).get(col);
        if (row < n - 1) {
            path += Math.min(compute(triangle, dp, row + 1, col, n), compute(triangle, dp, row + 1, col + 1, n));
        }
        return dp[row][col] = path;
    }

    public static void main(String[] args) {
        Triangle test = new Triangle();
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(List.of(2));
        triangle1.add(List.of(3, 4));
        triangle1.add(List.of(6, 5, 7));
        triangle1.add(List.of(4, 1, 8, 3));
        System.out.println(test.minimumTotal(triangle1));
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(List.of(-1));
        triangle2.add(List.of(2, 3));
        triangle2.add(List.of(1, -1, -3));
        System.out.println(test.minimumTotal(triangle2));
    }
}
