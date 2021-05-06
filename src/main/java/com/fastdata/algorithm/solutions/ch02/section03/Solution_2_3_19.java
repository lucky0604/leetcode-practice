package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/6/21 11:58 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_3_19 {

    public static void main(String[] args) {
        int numberOfExperiments = 8;
        int initialArraySize = 131072;

        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(numberOfExperiments, initialArraySize, 2);

        doExperiment(numberOfExperiments, initialArraySize, allInputArrays);
    }

    private static void doExperiment(int numberOfExperiments, int initialArraySize, Map<Integer, Comparable[]> allInputArrays) {

        StdOut.printf("%13s %23s %32s %30s\n", "Array Size | ", "QuickSort Running Time |",
                "QuickSort with median-of-three | ", "QuickSort with median-of-five");

        int arraySize = initialArraySize;

        for(int i = 0; i < numberOfExperiments; i++) {

            Comparable[] originalArray = allInputArrays.get(i);
            Comparable[] arrayCopy1 = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, arrayCopy1, 0, originalArray.length);
            Comparable[] arrayCopy2 = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, arrayCopy2, 0, originalArray.length);

            //Default QuickSort
            Stopwatch defaultQuickSortTimer = new Stopwatch();

            QuickSort.quickSort(originalArray);

            double defaultQuickSortRunningTime = defaultQuickSortTimer.elapsedTime();

            //QuickSort with median-of-three partitioning
            Stopwatch quickSortWithMedianOfThreeTimer = new Stopwatch();

            Solution_2_3_18.quickSortWithMedianOfThree(arrayCopy1);

            double quickSortWithMedianOfThreeRunningTime = quickSortWithMedianOfThreeTimer.elapsedTime();

            //QuickSort with median-of-five partitioning
            Stopwatch quickSortWithMedianOfFiveTimer = new Stopwatch();

            quickSortWithMedianOfFive(arrayCopy2);

            double quickSortWithMedianOfFiveRunningTime = quickSortWithMedianOfFiveTimer.elapsedTime();

            printResults(arraySize, defaultQuickSortRunningTime, quickSortWithMedianOfThreeRunningTime,
                    quickSortWithMedianOfFiveRunningTime);

            arraySize *= 2;
        }
    }

    private static void quickSortWithMedianOfFive(Comparable[] array) {
        StdRandom.shuffle(array);

        Comparable[] medianOf5Array = new Comparable[5];
        quickSort(array, 0, array.length - 1, medianOf5Array);
    }

    private static void quickSort(Comparable[] array, int low, int high, Comparable[] medianOf5Array) {
        if (low >= high) {
            return;
        }
        int partition = partition(array, low, high, medianOf5Array);
        quickSort(array, low, partition - 1, medianOf5Array);
        quickSort(array, partition + 1, high, medianOf5Array);
    }

    private static int partition(Comparable[] array, int low, int high, Comparable[] medianOf5Array) {
        medianOf5Partition(array, low, high, medianOf5Array);

        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;

        while (true) {
            while (ArrayUtil.less(array[++i], pivot)) {
                // since using a random sample, cannot guarantee that will always have a higher element than the pivot on the right end.
                // so this check is necessary
                if (i == high) {
                    break;
                }
            }

            while (ArrayUtil.less(pivot, array[ --j]));
            if (i >= j) {
                break;
            }
            ArrayUtil.exchange(array, i, j);
        }
        ArrayUtil.exchange(array, low, j);
        return j;
    }

    // Based on http://stackoverflow.com/questions/480960/code-to-calculate-median-of-five-in-c-sharp
    private static void medianOf5Partition(Comparable[] array, int low, int high, Comparable[] medianOf5Array) {

        // if we have less than 5 items, no need to partition on the median of 5, just pick the first item
        if (high - low + 1 < 5) {
            return;
        }

        int randomIndex1 = StdRandom.uniform(low, high + 1);
        int randomIndex2 = StdRandom.uniform(low, high + 1);
        int randomIndex3 = StdRandom.uniform(low, high + 1);
        int randomIndex4 = StdRandom.uniform(low, high + 1);
        int randomIndex5 = StdRandom.uniform(low, high + 1);

        medianOf5Array[0] = array[randomIndex1];
        medianOf5Array[1] = array[randomIndex2];
        medianOf5Array[2] = array[randomIndex3];
        medianOf5Array[3] = array[randomIndex4];
        medianOf5Array[4] = array[randomIndex5];

        Map<Comparable, Integer> originalIndexes = new HashMap<>();
        originalIndexes.put(medianOf5Array[0], randomIndex1);
        originalIndexes.put(medianOf5Array[1], randomIndex2);
        originalIndexes.put(medianOf5Array[2], randomIndex3);
        originalIndexes.put(medianOf5Array[3], randomIndex4);
        originalIndexes.put(medianOf5Array[4], randomIndex5);

        Comparable median;

        /**
         * 6 compares median-of-5 algorithm
         *
         * 1, put the numbers in an array
         * 2, use three comparisons and shuffle around the number so that a[1] < a[2], a[4] < a[5], and a[1] < a[4]
         * 3, if a[3] > a[2], then the problem is fairly easy. if a[2] < a[4], the median value is the smaller of a[3] and a[4]
         *      if not, the median value is the smaller of a[2] and a[5]
         * 4, else, if a[3] < a[2]: if a[3] > a[4], then the solution is the smaller of a[3] and a[5]
         *      otherwise, the solution is the smaller of a[2] and a[4]
         */
        // 1st compare
        if (!ArrayUtil.less(medianOf5Array[0], medianOf5Array[1])) {
            ArrayUtil.exchange(medianOf5Array, 0, 1);
        }
        // 2nd compare
        if (!ArrayUtil.less(medianOf5Array[3], medianOf5Array[4])) {
            ArrayUtil.exchange(medianOf5Array, 3, 4);
        }
        // 3rd compare
        if (!ArrayUtil.less(medianOf5Array[0], medianOf5Array[3])) {
            ArrayUtil.exchange(medianOf5Array, 0, 3);
        }

        // 4th compare
        if (ArrayUtil.less(medianOf5Array[1], medianOf5Array[2])) {
            // 5th compare
            if (ArrayUtil.less(medianOf5Array[1], medianOf5Array[3])) {
                // 6th compare
                if (ArrayUtil.less(medianOf5Array[2], medianOf5Array[3])) {
                    median = medianOf5Array[2];
                } else {
                    median = medianOf5Array[3];
                }
            } else {
                // 6th compare
                if (ArrayUtil.less(medianOf5Array[1], medianOf5Array[4])) {
                    median = medianOf5Array[1];
                } else {
                    median = medianOf5Array[4];
                }
            }
        } else {
            // 5th compare
            if (ArrayUtil.less(medianOf5Array[3], medianOf5Array[2])) {
                // 6th compare
                if (ArrayUtil.less(medianOf5Array[2], medianOf5Array[4])) {
                    median = medianOf5Array[2];
                } else {
                    median = medianOf5Array[4];
                }
            } else {
                // 6th compare
                if (ArrayUtil.less(medianOf5Array[1], medianOf5Array[3])) {
                    median = medianOf5Array[1];
                } else {
                    median = medianOf5Array[3];
                }
            }
        }

        int originalMedianIndex = originalIndexes.get(median);

        // swap median with low
        ArrayUtil.exchange(array, originalMedianIndex, low);
    }

    private static void printResults(int arraySize, double defaultQuickSortRunningTime, double quickSortWithMedianOfThree, double quickSortWithMedianOfFive) {
        StdOut.printf("%10d %25.1f %32.1f %33.1f\n", arraySize, defaultQuickSortRunningTime, quickSortWithMedianOfThree, quickSortWithMedianOfFive);
    }
}
