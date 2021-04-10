package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * name: TopdownMergeSort
 * date: 4/8/21 12:38 PM
 * author: lucky
 * version: 1.0
 * description:
 */

public class TopdownMergeSort {

    private static void mergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = arr[i];
        }
        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrIndex = low;

        while (leftIndex <= mid && rightIndex <= high) {
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                arr[arrIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                arr[arrIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrIndex ++;
        }

        while (leftIndex <= mid) {
            arr[arrIndex] = aux[leftIndex];
            leftIndex ++;
            arrIndex ++;
        }
    }
}
