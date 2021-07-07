package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/7 - 08:38
 * @Version: 1.0
 * @Description:
 **/

public class SurroundedRegions {

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // boundary O's to '*'
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, rows, cols);
                    }
                }
            }
        }

        // convert back
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int rows, int cols) {
        boolean isCurrSafe = isSafe(board, i, j, rows, cols);
        if (isCurrSafe) {
            board[i][j] = '*';
            dfs(board, i + 1, j, rows, cols);
            dfs(board, i - 1, j, rows, cols);
            dfs(board, i, j + 1, rows, cols);
            dfs(board, i, j - 1, rows, cols);
        }
    }

    private boolean isSafe(char[][] board, int i, int j, int rows, int cols) {
        if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'O') {
            return true;
        }
        return false;
    }
}
