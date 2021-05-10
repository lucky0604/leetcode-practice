package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.solutions.ch02.section01.InsertionSort;
import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Map;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/5/10 - 13:38
 */
public class Solution_2_3_24 {

    public static void main(String[] args) {
        int numberOfExperiments = 8;
        int initialArraySize = 131072;

        int k = 5;
        int sampleSize = (int) Math.pow(2, k) - 1;

        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(numberOfExperiments, initialArraySize, 2);

        doExperiment(numberOfExperiments, initialArraySize, sampleSize, allInputArrays);
    }

    private static void doExperiment(int numberOfExperiments, int initialArraySize, int sampleSize,
                                     Map<Integer, Comparable[]> allInputArrays) {

        StdOut.printf("%13s %23s %25s\n", "Array Size | ", "QuickSort Running Time |", "SampleSort Running Time");

        int arraySize = initialArraySize;

        for(int i = 0; i < numberOfExperiments; i++) {

            Comparable[] originalArray = allInputArrays.get(i);
            Comparable[] array = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);

            //Default QuickSort
            Stopwatch quickSortTimer = new Stopwatch();

            QuickSort.quickSort(originalArray);

            double quickSortRunningTime = quickSortTimer.elapsedTime();

            //SampleSort
            Stopwatch sampleSortTimer = new Stopwatch();

            sampleSort(array, sampleSize);

            double sampleSortRunningTime = sampleSortTimer.elapsedTime();

            printResults(arraySize, quickSortRunningTime, sampleSortRunningTime);

            arraySize *= 2;
        }
    }

    private static void sampleSort(Comparable[] array, int sampleSize) {
        StdRandom.shuffle(array);
        sampleSort(array, 0, array.length - 1, sampleSize);
    }

    private static void sampleSort(Comparable[] array, int low, int high, int sampleSize) {

        if (low >= high) {
            return;
        }
        int partition = partition(array, low, high, sampleSize);
        sampleSort(array, low, partition - 1, sampleSize);
        sampleSort(array, partition + 1, high, sampleSize);

    }

    private static int partition(Comparable[] array, int low, int high, int sampleSize) {
        if (sampleSize <= high - low + 1) {
            InsertionSort.insertionSort(array, low, low + sampleSize - 1);
            int pivotIndex = low + sampleSize / 2;      // median of the sample
            ArrayUtil.exchange(array, low, pivotIndex);
        }

        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;
        while (true) {
            while (ArrayUtil.less(array[++ i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (ArrayUtil.less(pivot, array[-- j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            ArrayUtil.exchange(array, i, j);
        }
        
        ArrayUtil.exchange(array, low, j);
        return j;

    }

    private static void printResults(int arraySize, double quickSortRunningTime, double sampleSortRunningTime) {
        StdOut.printf("%10d %25.1f %27.1f\n", arraySize, quickSortRunningTime, sampleSortRunningTime);
    }
}
