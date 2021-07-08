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
}
