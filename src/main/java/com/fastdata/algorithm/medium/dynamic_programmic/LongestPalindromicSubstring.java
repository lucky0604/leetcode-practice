package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/11 - 22:07
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 **/

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            dp[i][i] = true;
        }
        char[] charArr = s.toCharArray();

        for (int i = 2; i <= len; i ++) {
            for (int j = 0; j < len; j ++) {
                int m = i + j - 1;
                if (m >= len) {
                    break;
                }
                if (charArr[j] != charArr[m]) {
                    dp[j][m] = false;
                } else {
                    if (m - j < 3) {
                        dp[j][m] = true;
                    } else {
                        dp[j][m] = dp[j + 1][m - 1];
                    }
                }
                if (dp[j][m] && m - j + 1 > maxLen) {
                    maxLen = m - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
