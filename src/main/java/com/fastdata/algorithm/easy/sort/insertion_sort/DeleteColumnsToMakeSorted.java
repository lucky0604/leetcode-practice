package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/delete-columns-to-make-sorted/
 * @Date: create in 1/21/21 - 10:00 AM
 */
public class DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
//        String[] A = new String[]{"cba","daf","ghi"};
        String[] A = new String[]{"zyx","wvu","tsr"};
//        String[] A = new String[]{"a","b"};
        int ret = minDeletionSize(A);
        System.out.println(ret);
    }

    public static int minDeletionSize(String[] A) {
        // break跳出内循环，否则计数器重复计数
        int count = 0;
        for (int i = 0; i < A[0].length(); i ++) {
            for (int j = 0; j < A.length - 1; j ++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}
