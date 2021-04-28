package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 4/28/21 11:46 AM
 * @Version: 1.0
 * @Description:
 **/

public class QuickSort {

    public static void quickSort(Comparable[] array) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    // partition the array
    private static int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[low];

        int lowIndex = low;
        int highIndex = high + 1;

        while (true) {
            while (ArrayUtil.less(array[++lowIndex], pivot)) {
                if (lowIndex == high) {
                    break;
                }
            }
            while (ArrayUtil.less(pivot, array[--highIndex])) {
                if (highIndex == low) {
                    break;
                }
            }
            if (lowIndex >= highIndex) {
                break;
            }
            ArrayUtil.exchange(array, lowIndex, highIndex);
        }

        // place pivot in the right place
        ArrayUtil.exchange(array, low, highIndex);
        return highIndex;
    }
}
