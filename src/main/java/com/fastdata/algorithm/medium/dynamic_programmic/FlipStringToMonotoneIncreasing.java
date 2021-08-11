package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/11/21 10:39 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/flip-string-to-monotone-increasing/
 **/

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[2][s.length() + 1];
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '0') {
                dp[0][i + 1] = dp[0][i];
                dp[1][i + 1] = 1 + Math.min(dp[0][i], dp[1][i]);
            } else {
                dp[0][i + 1] = dp[0][i] + 1;
                dp[1][i + 1] = Math.min(dp[0][i], dp[1][i]);
            }
        }

        return Math.min(dp[0][s.length()], dp[1][s.length()]);
    }
}
