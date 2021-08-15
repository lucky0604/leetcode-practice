package com.fastdata.algorithm.hard.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/15/21 11:58 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/remove-boxes/
 **/

public class RemoveBoxes {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }

    private int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }
        int tmpi = i;
        int tmpk = k;
        while (i + 1 <= j && boxes[i + 1] == boxes[i]) {
            i ++;
            k ++;
        }
        int ret = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m ++) {
            if (boxes[i] == boxes[m]) {
                ret = Math.max(ret, helper(boxes, i + 1, m - 1, 0, dp) + helper(boxes, m, j, k + 1, dp));
            }
        }
        dp[tmpi][j][tmpk] = ret;
        return ret;
    }
}
