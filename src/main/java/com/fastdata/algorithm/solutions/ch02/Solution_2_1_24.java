package com.fastdata.algorithm.solutions.ch02;

/**
 * @Author: Lucky
 * @Description: Insertion sort with sentinel
 * Develop an implementation of insertion sort that
 * eliminates the j>0 test in the inner loop by first putting the smallest item into position.
 * Use SortCompare to evaluate the effectiveness of doing so. Note : It is often possible to
 * avoid an index-out-of-bounds test in this way—the element that enables the test to be
 * eliminated is known as a sentinel.
 * @Date: create in 3/30/21 - 1:05 PM
 */
public class Solution_2_1_24 {

    private static void insertionSortWithSentinel(Comparable[] arr) {
        Comparable minElement = Double.MAX_VALUE;
        int minIndex = -1;
        // count the min
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i].compareTo(minElement) < 0) {
                minElement = arr[i];
                minIndex = i;
            }
        }

        // move smallest element to the first position
        Comparable tmp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = tmp;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i; arr[j].compareTo(arr[j - 1]) < 0; j --) {
                Comparable temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
}
