package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/5 12:23
 * @Version: 1.0
 * @description: https://leetcode.com/problems/count-number-of-teams/
 **/

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int length = rating.length;
        int dp1[] = new int[length];
        int dp2[] = new int[length];

        for (int i = length - 2; i >= 0; i --) {
            for (int j = i + 1; j < length; j ++) {
                if (rating[i] < rating[j]) {
                    dp1[i] ++;
                } else {
                    dp2[i] ++;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < length - 2; i ++) {
            for (int j = i + 1; j < length - 1; j ++) {
                if (rating[i] < rating[j]) {
                    count += dp1[j];
                } else {
                    count += dp2[j];
                }
            }
        }

        return count;
    }
}
