package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/22/21 9:54 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/house-robber/
 **/

public class HouseRobber {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        dp[0] = new int[]{0, 0};

        for (int i = 1; i < dp.length; i ++) {
            dp[i][0] = nums[i - 1] + dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
