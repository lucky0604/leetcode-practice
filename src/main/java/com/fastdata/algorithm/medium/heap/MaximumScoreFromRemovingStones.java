package com.fastdata.algorithm.medium.heap;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-score-from-removing-stones/
 * @Date: create in 3/2/21 - 10:09 AM
 */
public class MaximumScoreFromRemovingStones {

    /**
     * Sort the numbers in ascending order for easy manipulation
     * if sum of smallest numbers is less than the largest number, then we can make a+b pairs
     * e.g., (a,b,c) -> 1 2 4
     * here a+b <= c, therefore we can
     * reduce (a,c) until a == 0
     * reduce (b,c) until b == 0
     * if sum of smallest numbers is greater than c, then we can (a+b)/2 pairs after making c empty
     * E.g., (a,b,c) -> 2 2 2
     * here a+b > c, therefore we can
     * reduce(a,c) then reduce(b,c) until c == 0 [c number of stones is removed from a and b in such a way that at the end there are almost same number of stones in a & b (maxDiff 1)]
     * using a & b we can make (a+b)/2 extra pairs
     * @param a
     * @param b
     * @param c
     * @return
     */

    public int maximumScore(int a, int b, int c) {
        // make sure a <= b <= c
        if (a > b) return maximumScore(b, a, c);
        if (b > c) return maximumScore(a, c, b);

        // if sum of smallest numbers [a + b] is less than c, then we can a + b pairs with the c
        if (a + b <= c) return a + b;

        // if sum of smallest numbers is greater than c, then (a + b) / 2 pairs after making c empty
        return c + (a + b - c) / 2;
    }
}
