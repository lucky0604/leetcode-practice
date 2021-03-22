package com.fastdata.algorithm.medium.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/pancake-sorting/
 * @Date: create in 3/22/21 - 10:23 AM
 */
// TODO: to be understand
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for (int n = arr.length; n > 0; n --) {
            int index = find(arr, n);
            flip(arr, index);
            flip(arr, n - 1);
            ret.add(index + 1);
            ret.add(n);
        }
        return ret;
    }

    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // do selection sort
    private void flip(int[] arr, int j) {
        int i = 0;
        while (i < j) {
            int temp = arr[i];
            arr[i ++] = arr[j];
            arr[j --] = temp;
        }
    }
}
