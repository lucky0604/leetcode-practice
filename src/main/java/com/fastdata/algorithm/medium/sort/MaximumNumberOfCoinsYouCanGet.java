package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 * @Date: created in 2021/3/21 - 22:06
 */
public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        // selection sort the piles
//        int minIndex = 0;
//        for (int i = 0; i < piles.length - 1; i ++) {
//            minIndex = i;
//            for (int j = i + 1; j < piles.length; j ++) {
//                if (piles[j] < piles[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int temp = piles[i];
//            piles[i] = piles[minIndex];
//            piles[minIndex] = temp;
//        }
        Arrays.sort(piles);
        int numOfSteps = piles.length / 3;
        int indexOfLastStep = (piles.length - 2) - 2 * numOfSteps;
        int sum = 0;
        for (int i = piles.length - 2; i > indexOfLastStep; i-=2) {
            sum += piles[i];
        }
        return sum;
    }
}
