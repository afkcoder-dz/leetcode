package com.java.leetcode.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandsNumber = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islandsNumber++;
                    DFS(grid, i, j);
                }
            }
        }
        return islandsNumber;
    }

    private void DFS(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        DFS(grid, row - 1, col);
        DFS(grid, row + 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandsNumber = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islandsNumber++;
                    backtrack(grid, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    grid[i][j] = '1';
                }
            }
        }
        return islandsNumber;
    }


    private void backtrack(char[][] grid, int row, int col) {
        if (row < 0 || row >=  grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'|| grid[row][col] == '*') {
            return;
        }

        grid[row][col] = '*';
        backtrack(grid, row - 1, col);
        backtrack(grid, row + 1, col);
        backtrack(grid, row, col - 1);
        backtrack(grid, row, col + 1);
    }




    private void DFS2(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        DFS(grid, row - 1, col);
        DFS(grid, row + 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }



    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result);
        int result2 = solution.numIslands2(grid);
        System.out.println("Number of islands 2: " + result2);
    }
}
