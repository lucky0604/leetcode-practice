package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_23_AvoidCopy
 * @create 2021-04-21 下午12:33
 */

public class Solution_2_2_23_AvoidCopy {

    public static void mergeSort(Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        // find the mid index
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);

        // merge two array
        merge(array, aux, low, mid, high);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;

        for (int i = low; i <= high; i ++) {
            if (leftIndex > mid) {
                aux[i] = array[rightIndex ++];
            } else if (rightIndex > high) {
                aux[i] = array[leftIndex ++];
            } else if (array[leftIndex].compareTo(array[rightIndex]) <= 0) {
                aux[i] = array[leftIndex ++];
            } else {
                aux[i] = array[rightIndex ++];
            }
        }
    }
}
