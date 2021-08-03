package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 10:58 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 **/

public class EggDropWith2EggsAndNFloors {

    public int twoEggDrops(int n) {
        int eggs = 2;
        int[][] dp = new int[eggs + 1][n + 1];
        int c = 0;

        for (int i = 0; i <= n; i ++) {
            dp[1][i] = i;
        }

        for (int f = 1; f <= n; f ++) {
            dp[2][f] = Integer.MAX_VALUE;
            for (int k = 1; k <= f; k ++) {
                c = 1 + Math.max(dp[1][k - 1], dp[2][f - k]);
                if (c < dp[2][f]) {
                    dp[2][f] = c;
                }
            }
        }
        return dp[eggs][n];
    }
}
