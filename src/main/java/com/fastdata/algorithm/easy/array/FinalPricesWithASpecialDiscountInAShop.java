package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * @Date: create in 1/27/21 - 12:57 PM
 */
public class FinalPricesWithASpecialDiscountInAShop {

    public static void main(String[] args) {

    }

    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i ++) {
            for (int j = i + 1; j < prices.length; j ++) {
                if (prices[i] - prices[j] >= 0) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
