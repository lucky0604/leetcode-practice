package com.fastdata.algorithm.solutions.ch02.section02;

import com.fastdata.algorithm.utils.ArrayGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 4/26/21 3:44 PM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_2_28 {

    private enum MergeSortType {
        TOP_DOWN,
        BOTTOM_UP
    }

    public static void main(String[] args) {
        List<Comparable[]> arrays = new ArrayList<>();
        Comparable[] array1 = ArrayGenerator.generateRandomArray(1000);
        Comparable[] array2 = ArrayGenerator.generateRandomArray(10000);
        Comparable[] array3 = ArrayGenerator.generateRandomArray(100000);
        Comparable[] array4 = ArrayGenerator.generateRandomArray(1000000);

        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        arrays.add(array4);

        sortCompare(arrays);
    }

    private static void sortCompare(List<Comparable[]> arrays) {
        int numberOfExperiments = 4;
        for (int i = 0; i < numberOfExperiments; i ++) {
            Comparable[] currentArray = arrays.get(i);
            double timeTopDownMergeSort = time(MergeSortType.TOP_DOWN, currentArray);
            double timeBottomUpMergeSort = time(MergeSortType.BOTTOM_UP, currentArray);
            StdOut.printf("For %d random doubles\\n top-down mergesort is", currentArray.length);
            StdOut.printf(" %.1f times faster than bottom-up mergersort.\\n", timeBottomUpMergeSort / timeTopDownMergeSort);
        }
    }

    private static double time(MergeSortType mergeSortType, Comparable[] originalArray) {
        Comparable[] copyArray = new Comparable[originalArray.length];
        System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);

        Stopwatch timer = new Stopwatch();

        if (mergeSortType == MergeSortType.BOTTOM_UP) {
            BottomUpMergeSort.mergeSort(copyArray);
        } else if (mergeSortType == MergeSortType.TOP_DOWN) {
            TopdownMergeSort.mergeSort(copyArray);
        }

        return timer.elapsedTime();
    }
}
