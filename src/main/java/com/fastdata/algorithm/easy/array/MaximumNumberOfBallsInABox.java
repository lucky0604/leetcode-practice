package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
 * @Date: created in 2021/3/14 - 22:36
 */
public class MaximumNumberOfBallsInABox {

    public int countBalls(int lowLimit, int highLimit) {
        int[] hashing = new int[highLimit + 1];

        int max = Integer.MIN_VALUE;

        for (int i = lowLimit; i <= highLimit; i ++) {
            int index = 0;
            int num = i;
            while (num > 0) {
                index = index + (num % 10);
                num = num / 10;
            }
            hashing[index] = hashing[index] + 1;
            if (hashing[index] > max)
                max = hashing[index];
        }
        return max;
    }
}
