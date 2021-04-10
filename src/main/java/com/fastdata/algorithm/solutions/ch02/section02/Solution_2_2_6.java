package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

/**
 * name: Solution_2_2_6
 * date: 4/8/21 12:38 PM
 * author: lucky
 * version: 1.0
 * description:
 */

public class Solution_2_2_6 {

    private static int numberOfArrayAccess;

    private enum SortType {
        TOP_DOWN_MERGESORT, BOTTOM_UP_MERGESORT;
    }

    public static void main(String[] args) {
        int intialArraySize = 1;
        int numberOfExperiments = 512;

        Map<Integer, Comparable[]> allInputArrays = generateAllArrays(intialArraySize, numberOfExperiments);
        StdOut.printf("%6s %15s %11s\n", "N", "Array Accesses", "Upper Bound");
        StdOut.println();

        StdOut.printf("Top-Down MergeSort");
        StdOut.println();
        doExperiments(SortType.TOP_DOWN_MERGESORT, 1, 512, allInputArrays);

        StdOut.println();
        StdOut.printf("Bottom-Up MergeSort");
        StdOut.println();
        doExperiments(SortType.BOTTOM_UP_MERGESORT, 1, 512, allInputArrays);
    }

    private static void doExperiments(SortType sortType, int arrLength, int numberOfExperiments, Map<Integer, Comparable[]> allInputArrays) {
        for (int i = 0; i < numberOfExperiments; i ++) {
            numberOfArrayAccess = 0;
            Comparable[] originalArr = allInputArrays.get(i);
            Comparable[] arr = new Comparable[originalArr.length];
            System.arraycopy(originalArr, 0, arr, 0, originalArr.length);
            if (sortType == SortType.TOP_DOWN_MERGESORT) {
                topdownMergeSort(arr);
            } else if (sortType == SortType.BOTTOM_UP_MERGESORT) {
                bottomUpMergeSort(arr);
            }
            printExperiment(arrLength);
            arrLength ++;
        }
    }

    private static void printExperiment(int arrLength) {
        double upperBound = 6 * arrLength * (Math.log10(arrLength) / Math.log10(2));
        StdOut.printf("%6d %15d %11.0f\n", arrLength, numberOfArrayAccess, upperBound);
    }

    private static void bottomUpMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for (int size = 1; size < arr.length; size = size + size) {
            for (int low = 0; low + size < arr.length; low += size + size) {
                int high = Math.min(low + size + size - 1, arr.length - 1);
                merge(arr, aux, low, low + size - 1, high);
            }
        }
    }

    private static void topdownMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        topdownMergeSort(arr, aux, 0, arr.length - 1);
    }

    private static void topdownMergeSort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        topdownMergeSort(arr, aux, low, mid);
        topdownMergeSort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = arr[i];
            numberOfArrayAccess += 2;
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
            numberOfArrayAccess += 4;
        }

        while (leftIndex <= mid) {
            arr[arrIndex] = aux[leftIndex];
            leftIndex ++;
            arrIndex ++;
            numberOfArrayAccess += 2;
        }
    }

    private static Map<Integer, Comparable[]> generateAllArrays(int initialArraySize, int numberOfExperiments) {
        Map<Integer, Comparable[]> allArrays = new HashMap<>();
        int arrSize = initialArraySize;
        for (int i = 0; i < numberOfExperiments; i ++) {
            Comparable[] arr = generateRandomArray(arrSize);
            allArrays.put(i, arr);
            arrSize ++;
        }
        return allArrays;
    }

    private static Comparable[] generateRandomArray(int arrLength) {
        Comparable[] arr = new Comparable[arrLength];
        for (int i = 0; i < arrLength; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }
}
