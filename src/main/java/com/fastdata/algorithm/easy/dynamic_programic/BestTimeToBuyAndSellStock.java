package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/6/28 11:15
 * @Version: 1.0
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 **/

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minProfit = prices[0];
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (minProfit > prices[i]) {
                minProfit = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - minProfit);
        }
        return dp[prices.length - 1];
    }
}
