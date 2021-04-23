package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/4/23 - 11:38
 */
public class Solution_2_2_26_ArrayCreationMergeSort {

    public static void mergeSort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(Comparable[] array, int low, int mid, int high) {
        Comparable[] aux = new Comparable[array.length];

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
            arrayIndex++;
        }
    }
}
