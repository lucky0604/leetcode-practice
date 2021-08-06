package com.fastdata.algorithm.medium.dynamic_programmic;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/6/21 12:11 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/stone-game/
 **/

public class StoneGame {

    int n;
    int[][] dp;

    public boolean stoneGame(int[] piles) {
        n = piles.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(dp[i], -1);
        }
        helper(0, piles, 0, piles.length - 1);
        return dp[0][n - 1] > 0;
    }

    private int helper(int playerToPlay, int[] piles, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return piles[start];
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int stones;
        if (playerToPlay == 0) {
            stones = Math.max(piles[start] + helper(1, piles, start + 1, end), piles[end] + helper(1, piles, start, end - 1));
        } else {
            stones = Math.min(-piles[start] + helper(0, piles, start + 1, end), -piles[end] + helper(0, piles, start, end - 1));
        }
        dp[start][end] = stones;
        return stones;
    }
}
