package com.fastdata.algorithm.hard.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-18 10:50 AM
 * @Version: 1.0
 * @description:
 **/
// tutorial: https://www.bilibili.com/video/BV1MZ4y1w7nK?from=search&seid=14399687229675688692
// TODO: to be understand
public class NQueens {

    private List<List<String>> ret;
    private char[][] nQueues;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    int n;

    public List<List<String>> solveNQueens(int n) {

        // init the value won't create extra spaces
        ret = new ArrayList<>();
        nQueues = new char[n][n];
        // fill the nqueues with '.'
        for (int i = 0; i < n; i ++) {
            Arrays.fill(nQueues[i], '.');
        }

        colUsed = new boolean[n];
        // there could draw 2 * n - 1 diagonals in a n * n grid's 45°, the same as 135°
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        this.n = n;

        // start loop from the first row
        backtracking(0);
        return ret;
    }

    private void backtracking(int row) {
        // if row == n, then we can put the n's queen, out of the loop
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars: nQueues) {
                list.add(new String(chars));
            }
            ret.add(list);
            return;
        }

        for (int col = 0; col < n; col ++) {
            // for 45° diagonals, all the points' index (row, col) are equal, row + col
            int diagonals45Index = row + col;
            // for 135° diagonals, is n - 1 - (row - col)
            int diagonals135Index = n - 1 - (row - col);
            if (colUsed[col] || diagonals45Used[diagonals45Index] || diagonals135Used[diagonals135Index]) {
                continue;
            }
            nQueues[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonals45Index] = diagonals135Used[diagonals135Index] = true;
            backtracking(row + 1);
            // back to previous step
            colUsed[col] = diagonals45Used[diagonals45Index] = diagonals135Used[diagonals135Index] = false;
            nQueues[row][col] = '.';
        }
    }
}
