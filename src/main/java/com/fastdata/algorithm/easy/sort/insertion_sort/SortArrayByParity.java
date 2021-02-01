package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-array-by-parity/
 * @Date: create in 1/20/21 - 11:01 AM
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int a: A) {
            if (a % 2 == 0) {
                stack1.add(a);
            } else {
                stack2.add(a);
            }

        }
        int[] ret = new int[stack1.size() + stack2.size()];
        List<Integer> temp = new ArrayList<>();
        while (!stack1.isEmpty()) {
            int i = stack1.pop();
            temp.add(i);
        }
        while (!stack2.isEmpty()) {
            int i = stack2.pop();
            temp.add(i);
        }
        for (int i = 0; i < temp.size(); i ++) {
            ret[i] = temp.get(i);
        }
        return ret;
    }

    public static int[] sortArrayByParityInsertionSort(int[] A) {
        if (A == null || A.length <= 1) return new int[]{};

        int length = A.length;
        int insertNum;

        for (int i = 1; i < length; i ++) {
            insertNum = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] % 2 != 0) {
                A[j + 1] = A[j];
                j --;
            }
            A[j + 1] = insertNum;
        }
        return A;

    }

    public static void main(String[] args) {
        int[] A = new int[]{3,1,2,4};
//        int[] ret = sortArrayByParity(A);
        int[] ret = sortArrayByParityInsertionSort(A);
        System.out.println("ret = " + Arrays.toString(ret));
    }
}
