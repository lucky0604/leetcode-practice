package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 * @Date: create in 3/24/21 - 10:08 AM
 */
public class TheKStrongestValuesInAnArray {

    public int[] getStrongest(int[] arr, int k) {
        // two pointer
        int[] res = new int[k];
        Arrays.sort(arr);
        int length = arr.length;
        int middleIndex = (length - 1) / 2;
        int median = arr[middleIndex];
        int index = 0;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if ((arr[right] - median) >= (median - arr[left])) {
                res[index ++] = arr[right --];
            } else {
                res[index ++] = arr[left ++];
            }
            if (index == k) {
                break;
            }
        }
        return res;
    }
}
