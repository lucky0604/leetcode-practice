package com.fastdata.algorithm.easy.binary_search;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/26/21 11:14 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/guess-number-higher-or-lower/
 **/

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = guess(mid);
            if (num == 0) {
                return mid;
            } else if (num < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int n) {
        return n;
    }
}
