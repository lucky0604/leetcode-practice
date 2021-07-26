package com.fastdata.algorithm.hard.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/26/21 11:19 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
 **/

public class NonNegativeIntegersWithoutConsecutiveOnes {

    public int findIntegers(int n) {
        if (n < 2) {
            return n + 1;
        }

        int[] dp = new int[30];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 30; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int m = 30;
        int sum = 0;
        int prev_bit = 0;
        while (m >= 0) {
            if ((n & (1 << m)) != 0) {
                sum += dp[m];
                if (prev_bit == 1) {
                    sum --;
                    break;
                }
                prev_bit = 1;
            } else {
                prev_bit = 0;
            }
            m --;
        }
        return sum + 1;
    }
}
