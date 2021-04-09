package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * name: Solution_2_2_7
 * date: 4/9/21 12:37 PM
 * author: lucky
 * version: 1.0
 * description:
 */

public class Solution_2_2_7 {


    private static int numberOfCompares;

    public static void main(String[] args) {
        boolean isMonotonicallyIncreasing = doExperiments(512);
        StdOut.println("is monotonically increasing: " + isMonotonicallyIncreasing);
    }

    private static boolean doExperiments(int numberOfExperiments) {
        int previousNumberOfCompares = -1;
        List<Double> values = new ArrayList<>();

        for (int i = 0; i < numberOfExperiments; i ++) {
            double randomValue = StdRandom.uniform();
            values.add(randomValue);

            Comparable[] arr = new Comparable[values.size()];
            values.toArray(arr);

            numberOfCompares = 0;

            topDownMergeSort(arr);

            if (numberOfCompares <= previousNumberOfCompares) {
                return false;
            } else {
                previousNumberOfCompares = numberOfCompares;
            }
        }
        return true;
    }

    private static void topDownMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        topDownMergeSort(arr, aux, 0, arr.length - 1);
    }

    private static void topDownMergeSort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        topDownMergeSort(arr, aux, low, mid);
        topDownMergeSort(arr, aux, mid + 1, high);
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
            numberOfCompares ++;
        }

        while (leftIndex <= mid) {
            arr[arrIndex] = aux[leftIndex];
            leftIndex ++;
            arrIndex ++;
        }
    }
}
