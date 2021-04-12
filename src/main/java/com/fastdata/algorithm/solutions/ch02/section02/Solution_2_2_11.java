package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Solution_2_2_11
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/12/21 12:59 PM
 */

public class Solution_2_2_11 {

    private static final int CUTOFF = 15;

    private static Comparable[] generateRandomArray(int arrLength) {
        Comparable[] arr = new Comparable[arrLength];
        for (int i = 0; i < arrLength; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    private static void topDownMergeSort(Comparable[] arr) {
        // improvement: Eliminate the copy of the auxiliary array on merge
        Comparable[] aux = arr.clone();
        topDownMergeSort(arr, aux, 0, arr.length  -1);
    }

    private static void topDownMergeSort(Comparable[] arr, Comparable[] aux, int low, int high) {
        // improvement: cutoff for small arrays
        if ((high - low) <= CUTOFF) {
            insertionSort(aux, low, high);
            return;
        }

        int mid = low + (high - low) / 2;
        topDownMergeSort(arr, aux, low, mid);
        topDownMergeSort(arr, aux, mid +1, high);

        // improvement: skip merge if the array is already in order
        if (arr[mid].compareTo(arr[mid + 1]) <= 0) {
            System.arraycopy(arr, low, aux, low, high - low + 1);
            return;
        }
        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;
        for (int i = low; i <= high; i ++) {
            if (leftIndex > mid) {
                aux[i] = arr[rightIndex ++];
            } else if (rightIndex > high) {
                aux[i] = arr[leftIndex ++];
            } else if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                aux[i] = arr[leftIndex ++];     // to ensure stability
            } else {
                aux[i] = arr[rightIndex ++];
            }
        }
    }

    private static void insertionSort(Comparable[] arr, int low, int high) {
        for (int i = low; i <= high; i ++) {
            for (int j = i; j > low && arr[j - 1].compareTo(arr[j]) > 0; j --) {
                Comparable tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}
