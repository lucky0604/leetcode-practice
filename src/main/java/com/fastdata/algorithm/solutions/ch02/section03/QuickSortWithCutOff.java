package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.solutions.ch02.section01.InsertionSort;
import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 4/28/21 12:44 PM
 * @Version: 1.0
 * @Description:
 **/

public class QuickSortWithCutOff {

    public static void quickSortWithCutOff(Comparable[] array, int cutoffSize) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1, cutoffSize);
    }

    private static void quickSort(Comparable[] array, int low, int high, int cutoffSize) {
        if (low >= high) {
            return;
        }

        int subArraySize = high - low + 1;
        if (subArraySize < cutoffSize) {
            InsertionSort.insertionSort(array, low, high);
            return;
        }

        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1, cutoffSize);
        quickSort(array, partition + 1, high, cutoffSize);
    }

    private static int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;

        while (true) {
            while (ArrayUtil.less(array[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (ArrayUtil.less(pivot, array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) break;
            ArrayUtil.exchange(array, i, j);
        }
        // place pivot in the right place
        ArrayUtil.exchange(array, low, j);
        return j;
    }
}
