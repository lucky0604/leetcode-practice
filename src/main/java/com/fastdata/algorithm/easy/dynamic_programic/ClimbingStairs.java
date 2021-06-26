package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/26/2021 4:49 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/climbing-stairs/
 **/

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
