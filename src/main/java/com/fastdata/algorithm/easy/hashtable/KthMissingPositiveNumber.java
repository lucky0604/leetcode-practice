package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kth-missing-positive-number/
 * @Date: created in 2021/2/15 - 12:54
 */
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        int curr = arr[0];
        int prevCount = 0;      // prev count of missing number
        int count = 0;          // count of missing number

        for (int i = 1; i <= arr.length; i ++) {
            if (prev != curr - 1) {
                prevCount = count;
                count += curr - prev - 1;

                if (count >= k) {
                    int index = k - prevCount;
                    return prev + index;
                }
            }
            prev = curr;
            if (i != arr.length)
                curr = arr[i];
        }
        return arr.length + k;
    }
}
