package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * @Date: create in 1/27/21 - 11:16 AM
 */
public class FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {

    }

    public static int[] sumZero(int n) {
        // corner case:
        int[] ret = new int[n];
        int max = n / 2;
        int j = 0;
        if (n % 2 == 0) {
            for (int i = -max; i <= max; i ++) {
                if (i != 0) {
                    ret[j ++] = i;
                }
            }
        } else {
            for (int i = -max; i <= max; i ++) {
                ret[j ++] = i;
            }
        }
        return ret;
    }
}
