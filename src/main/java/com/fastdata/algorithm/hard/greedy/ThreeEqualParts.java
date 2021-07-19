package com.fastdata.algorithm.hard.greedy;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/18 11:42
 * @Version: 1.0
 * @description: https://leetcode.com/problems/three-equal-parts/
 **/

public class ThreeEqualParts {

    public int[] threeEqualParts(int[] arr) {
        int numOne = 0;
        for (int i : arr) {
            if (i == 1) {
                numOne ++;
            }
        }

        int[] ret = {-1, -1};
        if (numOne == 0) {
            return new int[]{0, 2};    // special case
        }
        if (numOne % 3 != 0) {
            return ret;
        }

        int thirdPartStartIndex = 0;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; -- i) {
            if (arr[i] == 1) {
                if ( ++ count == numOne / 3) {
                    thirdPartStartIndex = i;
                    break;
                }
            }
        }
        int firstPartEndIndex = findNextEndIndexAndCompare(arr, 0, thirdPartStartIndex);
        if (firstPartEndIndex < 0) {
            return ret;
        }
        int secondPartEndIndex = findNextEndIndexAndCompare(arr, firstPartEndIndex + 1, thirdPartStartIndex);
        if (secondPartEndIndex < 0) {
            return ret;
        }

        return new int[]{firstPartEndIndex, secondPartEndIndex + 1};
    }

    private int findNextEndIndexAndCompare(int[] A, int start, int pacer) {
        while (A[start] == 0) {
            start ++;
        }
        while (pacer < A.length) {
            if (A[start] != A[pacer]) {
                return -1;
            }
            start ++;
            pacer ++;
        }
        return start - 1;
    }
}
