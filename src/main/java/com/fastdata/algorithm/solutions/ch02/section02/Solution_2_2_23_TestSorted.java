package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_23_TestSorted
 * @create 2021-04-21 下午12:25
 */

public class Solution_2_2_23_TestSorted {

    public static void mergeSort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);

        // skip merge if the array is sorted
        if (array[mid].compareTo(array[mid + 1]) <= 0) {
            return;
        }

        merge(array, aux, low, mid, high);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = array[i];
        }

        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrayIndex = low;

        while (leftIndex <= mid && rightIndex <= high) {
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                array[arrayIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                array[arrayIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrayIndex ++;
        }

        while (leftIndex <= mid) {
            array[arrayIndex] = aux[leftIndex];
            leftIndex ++;
            arrayIndex ++;
        }
    }
}
