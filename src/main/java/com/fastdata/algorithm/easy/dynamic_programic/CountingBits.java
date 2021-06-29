package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/6/29 10:30
 * @Version: 1.0
 * @description: https://leetcode.com/problems/counting-bits/
 **/

public class CountingBits {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i ++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        return dp;
    }

}
