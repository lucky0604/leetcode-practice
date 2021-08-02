package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 9:49 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 **/

public class CountSubstringsThatDifferByOneCharacter {

    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return countSubstrings(t, s);
        }

        int ret = 0;
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < m; i ++) {
            int[][] next = new int[n + 1][2];
            for (int j = 0; j < n; j ++) {
                next[j + 1][0] = (s.charAt(i) == t.charAt(j)) ? dp[j][0] + 1 : 0;
                next[j + 1][1] = (s.charAt(i) == t.charAt(j)) ? dp[j][1]: dp[j][0] + 1;
                ret += next[j + 1][1];
            }
            dp = next;
        }
        return ret;
    }
}
