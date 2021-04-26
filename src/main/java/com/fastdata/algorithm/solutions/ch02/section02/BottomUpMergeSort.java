package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * name: BottomUpMergeSort
 * date: 4/8/21 12:48 PM
 * author: lucky
 * version: 1.0
 * description:
 */

public class BottomUpMergeSort {

    public static void mergeSort(Comparable[] arr) {

        Comparable[] aux = new Comparable[arr.length];
        for (int size = 1; size < arr.length; size = size + size) {
            for (int low = 0; low + size < arr.length; low += size + low) {
                int high = Math.min(low + size + size - 1, arr.length - 1);
                merge(arr, aux, low, low + size - 1, high);
            }
        }
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
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
