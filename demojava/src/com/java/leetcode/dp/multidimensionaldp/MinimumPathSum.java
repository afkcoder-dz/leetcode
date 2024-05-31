package com.java.leetcode.dp.multidimensionaldp;

public class MinimumPathSum {

    // DP O(m*n), O(m*n)
    // Since the computation for a cell only depends on the current row and the previous row, we can reduce the space complexity to
    // O(n) by keeping only two rows in memory (or even one row, updating in place).
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    // backtracking, time complexity: O(m*n), without cache O(2^(m+n)), space complexity O(m+n)
    public int minPathSum1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Integer[][] cache = new Integer[rows][cols];

        return minPathSumHelper(grid, 0, 0, cache);
    }

    private int minPathSumHelper(int[][] grid, int row, int col, Integer[][] cache) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (row > grid.length - 1 || col > grid[0].length - 1) {
            return Integer.MAX_VALUE / 2;
        }

        if (cache[row][col] != null) {
            return cache[row][col];
        }
        int down = grid[row][col] + minPathSumHelper(grid, row + 1, col, cache);
        int right = grid[row][col] + minPathSumHelper(grid, row, col + 1, cache);

        cache[row][col] = Math.min(down, right);
        return cache[row][col];
    }


    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] grid1 = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(test.minPathSum1(grid1));
        System.out.println(test.minPathSum1(grid2));
    }
}
