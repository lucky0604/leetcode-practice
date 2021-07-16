package com.fastdata.algorithm.medium.dfs_bfs;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/14 11:30
 * @Version: 1.0
 * @description: https://leetcode.com/problems/count-sub-islands/
 **/

public class CountSubIslands {

    int m;
    int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid2[i][j] == 1) {
                    count ++;
                    dfs(grid1, grid2, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        // top
        if (i - 1 >= 0 && grid2[i - 1][j] == 1) {
            dfs(grid1, grid2, i - 1, j);
        }
        // bottom
        if (i + 1 < m && grid2[i + 1][j] == 1) {
            dfs(grid1, grid2, i + 1, j);
        }
        // left
        if (j - 1 >= 0 && grid2[i][j - 1] == 1) {
            dfs(grid1, grid2, i, j - 1);
        }
        // right
        if (j + 1 < n && grid2[i][j + 1] == 1) {
            dfs(grid1, grid2, i, j + 1);
        }
    }
}
