package com.fastdata.algorithm.solutions.ch02.section02;

import com.fastdata.algorithm.utils.ArrayGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_24
 * @create 2021-04-22 上午11:27
 */
// TODO: to be understand how to generate indexes
public class Solution_2_2_25 {

    public static void main(String[] args) {
        int numberOfExperiments = 8;
        int initialArraySize = 131072;
        Solution_2_2_25 multiwayMergeSort = new Solution_2_2_25();
        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(numberOfExperiments, initialArraySize, 2);
        for (int k = 2; k <= 10; k ++) {
            String text = k + "- WAY MERGESORT";
            StdOut.println(text);
            multiwayMergeSort.doExperiments(numberOfExperiments, initialArraySize, allInputArrays, k);
            StdOut.println();
        }
    }

    private void doExperiments(int numberOfExperiments, int initialArraySize, Map<Integer, Comparable[]> allInputArrays, int subArraysToMerge) {
        StdOut.printf("%13s %12s\n", "Array Size | ", "Running Time");

        int arraySize = initialArraySize;
        for (int i = 0; i < numberOfExperiments; i ++) {
            Comparable[] originalArray = allInputArrays.get(i);
            Comparable[] array = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);

            Stopwatch timer = new Stopwatch();
            kWayMergeSort(array, subArraysToMerge);
            double runningTime = timer.elapsedTime();
            printResults(arraySize, runningTime);
            arraySize *= 2;
        }
    }

    private void kWayMergeSort(Comparable[] array, int k) {
        Comparable[] aux = new Comparable[array.length];
        kWayMergeSort(array, aux, k, 0, array.length - 1);
    }

    private void kWayMergeSort(Comparable[] array, Comparable[] aux, int k, int low, int high) {
        if (low >= high) return;

        List<int[]> indexes = generateIndexes(k, low, high);
        int[] startIndexes = indexes.get(0);
        int[] endIndexes = indexes.get(1);
        for (int i = 0; i < k; i ++) {
            kWayMergeSort(array, aux, k, startIndexes[i], endIndexes[i]);
        }

        merge(array, aux, startIndexes, endIndexes);
    }

    private List<int[]> generateIndexes(int k, int low, int high) {
        int length = high - low + 1;
        int subArraySizes = length / k;
        int remainingValues = length % k;

        List<int[]> indexes = new ArrayList<>();
        int[] startIndexes = new int[k];
        int[] endIndexes = new int[k];

        for (int i = 0; i < startIndexes.length; i ++) {
            if (i == 0) {
                startIndexes[i] = low;
            } else {
                startIndexes[i] = Math.min(endIndexes[i - 1] + 1, high);
            }

            int extraValue = 0;
            if (remainingValues > 0) {
                extraValue = 1;
                remainingValues --;
            }

            endIndexes[i] = Math.min(startIndexes[i] + subArraySizes - 1 + extraValue, high);
        }

        indexes.add(startIndexes);
        indexes.add(endIndexes);
        return indexes;
    }

    private void merge(Comparable[] array, Comparable[] aux, int[] startIndexes, int[] endIndexes) {
        int low = startIndexes[0];
        int high = -1;

        for (int i = 0; i < endIndexes.length; i ++) {
            if (endIndexes[i] > high) {
                high = endIndexes[i];
            }
        }

        for (int i = low; i <= high; i ++) {
            aux[i] = array[i];
        }

        for (int i = low; i <= high; i ++) {
            Comparable bestValue = -1;
            int bestIndex = -1;

            for (int j = 0; j < startIndexes.length; j ++) {
                int index = startIndexes[j];

                if (index <= endIndexes[j] && (bestIndex == -1 || aux[index].compareTo(bestValue) < 0)) {
                    bestValue = aux[index];
                    bestIndex = j;
                }
            }

            if (bestIndex != -1) {
                array[i] = bestValue;
                startIndexes[bestIndex] ++;
            }
        }
    }

    private void printResults(int arraySize, double runningTime) {
        StdOut.printf("%10d %15.1f\n", arraySize, runningTime);
    }
}
