package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Solution_2_2_10
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/12/21 12:09 PM
 */

public class Solution_2_2_10 {

    public static void main(String[] args) {
        Comparable[] arr = generateRandomArray(1000);
        topDownMergeSort(arr);
    }

    private static Comparable[] generateRandomArray(int arrLength) {
        Comparable[] arr = new Comparable[arrLength];
        for (int i = 0; i < arrLength; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    public static void topDownMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        topDownMergeSort(arr, aux, 0, arr.length - 1);
    }

    private static void topDownMergeSort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;

        topDownMergeSort(arr, aux, low, mid);
        topDownMergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        int auxIndex = low;
        for (int i = low; i < arr.length; i ++) {
            aux[auxIndex] = arr[i];
            auxIndex ++;
        }

        for (int i = high; i >= mid + 1; i --) {
            aux[auxIndex] = arr[i];
            auxIndex ++;
        }

        int leftIndex = low;
        int rightIndex = high;
        int arrIndex = low;

        while (leftIndex <= mid) {
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                arr[arrIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                arr[arrIndex] = aux[rightIndex];
                rightIndex --;
            }
            arrIndex ++;
        }
    }
}
