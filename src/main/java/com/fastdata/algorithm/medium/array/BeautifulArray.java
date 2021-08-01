package com.fastdata.algorithm.medium.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 10:57 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/beautiful-array/
 **/

public class BeautifulArray {

    public int[] beautifulArray(int n) {
        int[] ret = new int[n];
        if (n == 1) {
            ret[0] = 1;
            return ret;
        }
        int[] right = beautifulArray(n / 2);
        int[] left = beautifulArray((n + 1) / 2);
        for (int i = left.length; i < n; i ++) {
            ret[i] = right[i - left.length] * 2;
        }
        for (int i = 0; i < left.length; i ++) {
            ret[i] = left[i] * 2 - 1;
        }
        return ret;
    }
}
