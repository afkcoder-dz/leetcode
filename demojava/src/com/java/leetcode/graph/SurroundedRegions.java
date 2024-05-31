package com.java.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                DFS(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                DFS(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                DFS(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                DFS(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void DFS(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '*';
        DFS(board, row - 1, col);
        DFS(board, row + 1, col);
        DFS(board, row, col - 1);
        DFS(board, row, col + 1);
    }

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] board = {
                {'O', 'X', 'O', '0', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'X'}
        };
        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board2);
    }

    // Use BFS
    public void solve2(char[][] board) {
        if (board.length == 0)
            return;

        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();

        // get all 'O's on the edge first
        for (int r = 0; r < rowN; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = '+';
                queue.add(new Point(r, 0));
            }
            if (board[r][colN - 1] == 'O') {
                board[r][colN - 1] = '+';
                queue.add(new Point(r, colN - 1));
            }
        }

        for (int c = 0; c < colN; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = '+';
                queue.add(new Point(0, c));
            }
            if (board[rowN - 1][c] == 'O') {
                board[rowN - 1][c] = '+';
                queue.add(new Point(rowN - 1, c));
            }
        }

        // BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            board[row][col] = '+';
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                queue.add(new Point(row - 1, col));
            }
            if (row + 1 < rowN && board[row + 1][col] == 'O') {
                queue.add(new Point(row + 1, col));
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                queue.add(new Point(row, col - 1));
            }
            if (col + 1 < colN && board[row][col + 1] == 'O') {
                queue.add(new Point(row, col + 1));
            }
        }

        // turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '+')
                    board[i][j] = 'O';
            }
        }
    }

    static class Point {

        public int x;
        public int y;

        public Point(int row, int col) {
            this.x = row;
            this.y = col;
        }
    }
}

