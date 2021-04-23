package com.fastdata.algorithm.solutions.ch02.section02;

import com.fastdata.algorithm.utils.ArrayGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Map;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/4/23 - 14:44
 */
public class Solution_2_2_26_ArrayCreation {

    private enum MergeSortType {
        CREATE_AUX_IN_SORT, CREATE_AUX_IN_MERGE;
    }

    public static void main(String[] args) {
        int numberOfExperiments = 4;
        int initialArraySize = 131072;
        sortCompare(numberOfExperiments, initialArraySize);
    }

    private static void sortCompare(int numberOfExperiments, int initialArraySize) {
        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(numberOfExperiments, initialArraySize, 2);
        double timeCreateAuxInSort = timeRandomInput(MergeSortType.CREATE_AUX_IN_SORT, allInputArrays, numberOfExperiments);
        double timeCreateAuxInMerge = timeRandomInput(MergeSortType.CREATE_AUX_IN_MERGE, allInputArrays, numberOfExperiments);
        StdOut.printf("For %d experiments with random double arrays of sizes from %d to %d\n creating aux[] in Sort is",
                numberOfExperiments, initialArraySize, initialArraySize * 16);
        StdOut.printf(" %.1f times faster than creating aux[] in Merge.", timeCreateAuxInMerge / timeCreateAuxInSort);
    }

    private static double timeRandomInput(MergeSortType mergeSortType, Map<Integer, Comparable[]> allInputArrays, int numberOfExperiments) {
        double total = 0;

        for (int experiment = 0; experiment < numberOfExperiments; experiment ++) {
            Comparable[] originalArray = allInputArrays.get(experiment);
            Comparable[] array = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);
            total += time(mergeSortType, array);
        }
        return total;
    }

    public static double time(MergeSortType mergeSortType, Comparable[] array) {
        Stopwatch timer = new Stopwatch();

        if (mergeSortType == MergeSortType.CREATE_AUX_IN_SORT) {
            TopdownMergeSort.mergeSort(array);
        } else if (mergeSortType == MergeSortType.CREATE_AUX_IN_MERGE) {
            Solution_2_2_26_ArrayCreationMergeSort.mergeSort(array);
        }
        return timer.elapsedTime();
    }
}
