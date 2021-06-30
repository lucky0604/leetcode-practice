package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/6/30 11:39
 * @Version: 1.0
 * @description: https://leetcode.com/problems/is-subsequence/
 **/

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= t.length(); i ++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i ++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= t.length(); j ++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] && dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
