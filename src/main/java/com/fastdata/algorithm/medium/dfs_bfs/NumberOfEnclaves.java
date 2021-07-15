package com.fastdata.algorithm.medium.dfs_bfs;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/15 10:46
 * @Version: 1.0
 * @description: https://leetcode.com/problems/number-of-enclaves/
 **/

public class NumberOfEnclaves {

    int m;
    int n;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid == null || m == 0) {
            return 0;
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        dfs(grid, i, j);
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
