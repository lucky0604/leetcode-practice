package com.fastdata.algorithm.medium.greedy;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/4/21 11:27 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 **/

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length];
        int maxProfit = 0;
        int prevProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < length; i ++) {
            dp[i] = prices[i] - fee - minPrice + prevProfit;
            if (prevProfit - minPrice < maxProfit - prices[i]) {
                prevProfit = maxProfit;
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }
}
