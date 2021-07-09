package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/9 - 17:44
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/max-area-of-island/
 **/

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    int val = dfs(grid, i, j);
                    ans = Math.max(ans, val);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);
        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        return up + down + left + right + 1;
    }
}
