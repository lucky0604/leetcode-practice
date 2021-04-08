package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * name: HIndex
 * date: 4/8/21 11:13 AM
 * author: lucky
 * version: 1.0
 * description: https://leetcode.com/problems/h-index/
 */

public class HIndex {

    /**
     * Definition of H-Index
     * https://en.wikipedia.org/wiki/H-index
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        // sort the array with desc
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i ++) {
            arr[i] = citations[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        // find the citations[i] and compare with the i index
        int ret = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (i + 1 > arr[i]) {
                ret = i;
                return ret;
            } else {
                continue;
            }
        }
        return arr.length;
    }
}
