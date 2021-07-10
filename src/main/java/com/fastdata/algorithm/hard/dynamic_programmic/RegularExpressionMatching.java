package com.fastdata.algorithm.hard.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-24 10:59 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/regular-expression-matching/
 **/

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        boolean valid = false;
        for (int i = 2; i <= pLength; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
                valid = true;
            } else {
                valid = false;
            }
            if (!valid) {
                break;
            }
        }

        for (int i = 1; i <= sLength; i ++) {
            for (int j = 1; j <= pLength; j ++) {
                dp[i][j] = false;
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[sLength][pLength];
    }
}
