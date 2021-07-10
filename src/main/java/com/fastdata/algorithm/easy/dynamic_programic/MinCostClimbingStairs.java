package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/1 18:42
 * @Version: 1.0
 * @description: https://leetcode.com/problems/min-cost-climbing-stairs/
 **/

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= length; i ++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length];
    }
}
