package com.fastdata.algorithm.easy.array;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * @Date: create in 1/28/21 - 10:59 AM
 */
public class MakeTwoArraysEqualByReversingSubarrays {

    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i ++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
