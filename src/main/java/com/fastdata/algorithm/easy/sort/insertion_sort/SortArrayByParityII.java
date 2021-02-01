package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 1/21/21 - 10:46 AM
 */
public class SortArrayByParityII {

//    public int[] sortArrayByParityII(int[] A) {
//        Deque<Integer> oddStack = new ArrayDeque<>();
//        Deque<Integer> evenStack = new ArrayDeque<>();
//        for (int i = 0; i < A.length; i ++) {
//            if (A[i] % 2 == 0) {
//                evenStack.add(A[i]);
//            } else {
//                oddStack.add(A[i]);
//            }
//        }
//        int[] ret = new int[evenStack.size() + oddStack.size()];
//        int index = 0;
//        while (!oddStack.isEmpty() && !evenStack.isEmpty()) {
//            ret[index] = evenStack.pop();
//            ret[index + 1] = oddStack.pop();
//            index += 2;
//        }
//        return ret;
//    }
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] % 2 == 0) {
                while (A[j] % 2 == 0) {
                    j += 2;
                }
                // swap
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
