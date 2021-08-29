package com.fastdata.algorithm.easy.dfs_bfs;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/29/21 9:15 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 **/

public class SumOfAllOddLengthSubarrays {

    int ret = 0;

    public int sumOfAllOddLengthSubarrays(int[] arr) {
        dfs(arr, 0, 0);
        return ret;
    }

    private void dfs(int[] arr, int i, int j) {
        if (i == arr.length) {
            return;
        }
        if (j == arr.length) {
            return;
        }
        if ((j - i + 1) % 2 == 1) {
            sum(arr, i, j);
        }
        dfs(arr, i, ++ j);
        if (j >= arr.length) {
            i += 1;
            dfs(arr, i, i);
        }
    }

    private void sum(int[] arr, int i, int j) {
        while (i <= j) {
            ret += arr[j--];
        }
    }
}
