package com.fastdata.algorithm.hard.dynamic_programmic;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/7 - 00:07
 * @Version: 1.0
 * @Description:
 **/

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[] dp = new int[satisfaction.length];
        dp[0] = getSum(satisfaction, 0);

        for (int i = 1; i < satisfaction.length; i ++) {
            dp[i] = getSum(satisfaction, i);
            if (dp[i - 1] >= dp[i]) {
                return dp[i - 1];
            }
        }
        return 0;
    }

    private int getSum(int[] cur, int start) {
        int sum = 0;
        int time = 1;
        for (int j = start; j < cur.length; j ++, time ++) {
            sum = sum + (cur[j] * time);
        }

        return sum;
    }
}
