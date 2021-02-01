package com.fastdata.algorithm.easy.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * @Date: create in 1/15/21 - 12:06 PM
 */
public class NRepeatedElementInSize2NArray {
    /**
     * 基本思路：
     * 利用HashSet
     * @param A
     * @return
     */

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i ++) {
            if (set.contains(A[i])) {
                return A[i];
            }
            set.add(A[i]);
            // keep the set of a fixed size I remove the leftmost element.
            // This means that the set is never grows more than a 3 elements
            if (i >= 3) set.remove(A[i - 3]);
        }
        return -1;
    }
}
