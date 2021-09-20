package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/20 - 12:37
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 **/

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int ret = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i ++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ret = cnt[i];
            } else if (dp[i] == maxLen) {
                ret += cnt[i];
            }
        }
        return ret;
    }
}
