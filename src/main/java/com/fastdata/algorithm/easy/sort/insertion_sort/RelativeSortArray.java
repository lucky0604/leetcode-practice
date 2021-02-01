package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/relative-sort-array/
 * @Date: create in 1/21/21 - 11:27 AM
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        relativeSortArray(arr1, arr2);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // create a stack to collect all the item in arr2
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> notIn = new ArrayList<>();
        for (int i = 0; i < arr2.length; i ++) {
            for (int j = 0; j < arr1.length; j ++) {
                if (arr2[i] == arr1[j]) {
                    stack.add(arr1[j]);
                }
                set.add(arr2[i]);
            }
        }
        for (int i = 0; i < arr1.length; i ++) {
            if (!set.contains(arr1[i])) {
                notIn.add(arr1[i]);
            }
        }
        Collections.sort(notIn);
        List<Integer> temp = new ArrayList<>();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        temp.addAll(notIn);
        int[] ret = new int[temp.size()];
        for (int i = 0; i < temp.size(); i ++) {
            ret[i] = temp.get(i);
        }
        return ret;
    }
}
