package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-03 10:02 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 **/

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int ret = 0;
        int sell = 0;
        int buy = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1]) {
                // means we can sell the stock in this position
                sell ++;
            } else {
                // if not higher than next day, then sell the stock, and reset the position
                ret += prices[sell] - prices[buy];
                sell = i;
                buy = i;
            }
        }
        ret += prices[sell] - prices[buy];
        return ret;
    }
}
