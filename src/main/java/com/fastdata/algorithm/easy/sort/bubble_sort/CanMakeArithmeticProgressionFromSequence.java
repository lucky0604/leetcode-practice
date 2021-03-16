package com.fastdata.algorithm.easy.sort.bubble_sort;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 * @Date: create in 3/16/21 - 11:44 AM
 */
public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i ++) {
            for (int j = 0; j < length - 1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i ++) {
            set.add(arr[i + 1] - arr[i]);
        }
        if (set.size() > 1) {
            return false;
        } else {
            return true;
        }
    }
}
