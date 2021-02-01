package com.fastdata.algorithm.easy.binary_search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/intersection-of-two-arrays/
 * @Date: create in 12/21/20 - 10:24 AM
 */
public class Intersection {
    public static void main(String[] args) {
        int[] result = intersection(new int[]{1,2,3,4}, new int[]{3,5,6,7, 8, 2});
        System.out.println(" result = ");
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // because of each element in the result must be unique, here should use Set data structure
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for (int num: result) {
            arr[i] = num;
            i ++;
        }
        return arr;
    }
}
