package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.utils.ArrayGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/12/21 11:25 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_3_25 {

    private static final int NUMBER_OF_EXPERIMENTS = 4;

    public static void main(String[] args) {
        Map<Integer, Comparable[]> allInputArrays = new HashMap<>();
        int arraySize = 1000;

        for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
            Comparable[] array = ArrayGenerator.generateRandomArray(arraySize);
            allInputArrays.put(i, array);
            arraySize *= 10;
        }
        doExperiments(allInputArrays);
    }

    private static void doExperiments(Map<Integer, Comparable[]> allInputArray) {
        StdOut.printf("%13s %23s\n", "Cutoff size | ", "Average Running Time | ");
        for (int cutoffSize = 0; cutoffSize <= 30; cutoffSize ++) {
            double totalRunningTime = 0;

            for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i ++) {
                Comparable[] originalArray = allInputArray.get(i);
                Comparable[] array = new Comparable[originalArray.length];
                System.arraycopy(originalArray, 0, array, 0, originalArray.length);

                Stopwatch timer = new Stopwatch();
                QuickSortWithCutOff.quickSortWithCutOff(array, cutoffSize);
                totalRunningTime += timer.elapsedTime();
            }

            printResults(cutoffSize, totalRunningTime / NUMBER_OF_EXPERIMENTS);
        }
    }

    private static void printResults(int cutoffSize, double averageRunningTime) {
        StdOut.printf("%11d %26.5f\n", cutoffSize, averageRunningTime);
    }
}
