package com.fastdata.algorithm.easy.binary_search;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-25 8:14 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/sqrtx/
 **/

public class SqrtX {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long ret = 0;
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = (left + right) / 2;
            if ((mid * mid) <= x) {
                ret = Math.max(ret, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ret;
    }
}
