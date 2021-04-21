package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_23_Cutoff
 * @create 2021-04-21 下午12:14
 */

public class Solution_2_2_23_Cutoff {
    private int cutoff;

    Solution_2_2_23_Cutoff(int cutoff) {
        this.cutoff = cutoff;
    }

    public void mergeSort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        // cutoff for small arrays
        if (high - low <= cutoff) {
            insertionSort(array, low, high);
            return;
        }

        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    private void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
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

    private void insertionSort(Comparable[] array, int low, int high) {
        for (int i = low; i < high; i ++) {
            for (int j = i; j > low && array[j - 1].compareTo(array[j]) > 0; j --) {
                Comparable tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
            }
        }
    }
}
