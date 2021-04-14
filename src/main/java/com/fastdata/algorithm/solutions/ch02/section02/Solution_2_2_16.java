package com.fastdata.algorithm.solutions.ch02.section02;

import com.fastdata.algorithm.utils.ArrayGenerator;

/**
 * @ClassName: Solution_2_2_16
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/14/21 12:44 PM
 */

public class Solution_2_2_16 {

    public static void main(String[] args) {
        Comparable[] arr = ArrayGenerator.generateRandomArray(1000);
        naturalMergeSort(arr);
    }

    private static void naturalMergeSort(Comparable[] arr) {
        if (arr == null || arr.length == 1) return;
        Comparable[] aux = new Comparable[arr.length];

        int low = 0;
        int mid;
        int high;
        while (true) {
            mid = findSortedSubarray(arr, low);
            if (mid == arr.length - 1) {
                break;
            } else {
                low = 0;
                continue;
            }
        }
        high = findSortedSubarray(arr, mid + 1);
        BottomUpMergeSort.merge(arr, aux, low, mid, high);
        low = (high == arr.length - 1) ? 0: high + 1;
    }

    // find a sorted sub array
    // by incrementing a pointer until finding an entry that is smaller than its predecessor in the array
    private static int findSortedSubarray(Comparable[] arr, int start) {
        for (int i = start; i < arr.length; i ++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                return i - 1;
            }
        }
        return arr.length - 1;
    }
}
