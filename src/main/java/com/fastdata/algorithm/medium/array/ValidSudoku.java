package com.fastdata.algorithm.medium.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/17 - 21:51
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/valid-sudoku/
 **/

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index] ++;
                    columns[j][index] ++;
                    subboxes[i / 3][j / 3][index] ++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
