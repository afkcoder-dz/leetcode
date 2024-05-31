package com.java.leetcode.dp.multidimensionaldp;

import java.util.Arrays;

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return uniquePathsWithObstaclesHelper(obstacleGrid, 0, 0, dp);
    }

    private int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int row, int col, int[][] dp) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1 && obstacleGrid[row][col] != 1) {
            return 1;
        }

        if (row > obstacleGrid.length - 1 || col > obstacleGrid[0].length - 1 || obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int result = uniquePathsWithObstaclesHelper(obstacleGrid, row + 1, col, dp) + uniquePathsWithObstaclesHelper(obstacleGrid, row, col + 1, dp);
        dp[row][col] = result;
        return result;
    }

    public static void main(String[] args) {
        UniquePathII test = new UniquePathII();
        System.out.println(test.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(test.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
