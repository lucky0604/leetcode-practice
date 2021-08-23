package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/8 - 23:21
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/number-of-islands/
 **/

public class NumberOfIslands {

    /** Union Find solution
    int count = 0;

    public int numIslands(char[][] grids) {
        int m = grids.length;
        int n = grids[0].length;
        int[] nums = new int[m * n];

        for (int k = 0; k < m * n; k ++) {
            nums[k] = k;
        }

        count = m * n;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grids[i][j] == '1') {
                    if (i - 1 >= 0 && grids[i - 1][j] == '1') {
                        unify(nums, i, j, i - 1, j, n);
                    }
                    if (j - 1 >= 0 && grids[i][j - 1] == '1') {
                        unify(nums, i, j, i, j - 1, n);
                    }

                } else {
                    count --;
                }
            }
        }
        return count;
    }

    private void unify(int[] nums, int i1, int j1, int i2, int j2, int n) {
        int x = find(nums, i1, j1, n);
        int y = find(nums, i2, j2, n);
        if (x != y) {
            nums[x] = y;
            count --;
        }
    }

    private int find(int[] nums, int i, int j, int n) {
        return find(nums, i * n + j);
    }

    private int find(int[] nums, int k) {
        int root = k;
        while (nums[root] != root) {
            root = nums[root];
        }
        while (nums[k] != k) {
            int tmp = nums[k];
            nums[k] = root;
            k = tmp;
        }

        return root;
    }
     */

    // DFS solution
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 统计岛屿的个数
        int count = 0;
        // 两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                // 只有当格子是1才开始计算
                if (grid[i][j] == '1') {
                    // 如果当前格子是1，岛屿数量加1
                    count ++;
                    // 然后通过dfs把当前格子的上下左右4个位置为1的都要置为0，因为他们是连在一起的算一个岛屿
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // 这个方法会把当前格子以及临近的为1的格子都会置为1
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 把当前格子置为0，再从上下左右四个方向继续遍历
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}
