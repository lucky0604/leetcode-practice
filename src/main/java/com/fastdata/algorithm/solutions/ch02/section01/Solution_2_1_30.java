package com.fastdata.algorithm.solutions.ch02.section01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

/**
 * name: Solution_2_1_30
 * date: 4/7/21 12:08 PM
 * author: lucky
 * version: 1.0
 * description:
 * Geometric increments. Run experiments to determine a value of t that leads to
 * the lowest running time of shellsort for random arrays for the increment sequence 1,
 * ⎣t⎦, ⎣t 2⎦, ⎣t 3⎦, ⎣t 4⎦, . . . for N = 10 6. Give the values of t and the increment sequences for
 * the best three values that you find
 */

public class Solution_2_1_30 {
    private static double[] minimumTimes = new double[3];
    private static int[] bestTValues = new int[3];
    private static List<Integer[]> bestIncrementSequences = new ArrayList<>();

    public static void main(String[] args) {
        int arrLength = 1000000;
        int numberOfExperiments = 10;
        for (int i = 0; i < minimumTimes.length; i ++) {
            minimumTimes[i] = Double.MAX_VALUE;
            bestIncrementSequences.add(new Integer[]{});
        }
        timeToRandomInput(arrLength, numberOfExperiments);
        showBestTValueAndIncrementSequences();
    }

    private static void showBestTValueAndIncrementSequences() {
        for (int i = 0; i < bestTValues.length; i ++) {
            StdOut.printf("Best %d tValue: %d", i + 1, bestTValues[i]);
            StdOut.printf("Best %d sequence:\n", i + 1);
            Integer[] incrementSequence = bestIncrementSequences.get(i);
            for (int j = 0; j < incrementSequence.length; j ++) {
                StdOut.print(incrementSequence[j] + " ");
            }
            StdOut.println();
            StdOut.println();
        }
    }

    private static void timeToRandomInput(int arrLength, int numberOfExperiments) {
        int tValue = 2;
        for (int experiment = 0; experiment < numberOfExperiments; experiment ++) {
            Comparable[] arr = new Comparable[arrLength];
            for (int i = 0; i < arrLength; i ++) {
                arr[i] = StdRandom.uniform();
            }
            Integer[] incrementSequence = generateIncrementSequence(tValue, arrLength);
            double time = time(arr, incrementSequence);
            updateMinimumTimes(time, tValue, incrementSequence);
            tValue ++;
        }
    }

    private static void updateMinimumTimes(double currentTime, int tValue, Integer[] incrementSequence) {
        int timeToReplace = -1;
        for (int i = 0; i < minimumTimes.length; i ++) {
            if (currentTime < minimumTimes[i]) {
                timeToReplace = i;
                break;
            }
        }

        if (timeToReplace == -1) {
            return;
        }
        minimumTimes[timeToReplace] = currentTime;
        bestTValues[timeToReplace] = tValue;
        bestIncrementSequences.set(timeToReplace, incrementSequence);

    }

    public static double time(Comparable[] arr, Integer[] incrementSequence) {
        Stopwatch timer = new Stopwatch();
        shellSort(arr, incrementSequence);
        return timer.elapsedTime();
    }

    private static Integer[] generateIncrementSequence(int tValue, int arrLength) {
        int maxIncrement = 1;
        int numberOfIncrements = 1;
        int value = tValue;
        while (value < arrLength) {
            maxIncrement = value;
            value *= tValue;
            numberOfIncrements ++;
        }
        Integer[] incrementSequence = new Integer[numberOfIncrements];

        int index = 0;
        while (maxIncrement > 0) {
            incrementSequence[index] = maxIncrement;
            maxIncrement /= tValue;
            index ++;
        }
        return incrementSequence;
    }

    private static void shellSort(Comparable[] arr, Integer[] incrementSequence) {
        for (int increment: incrementSequence) {
            for (int j = increment; j < arr.length; j ++) {
                int currentIndex  = j;
                while (currentIndex >= increment && arr[currentIndex].compareTo(arr[currentIndex - increment]) < 0) {
                    Comparable tmp = arr[currentIndex];
                    arr[currentIndex] = arr[currentIndex - increment];
                    arr[currentIndex - increment] = tmp;
                    currentIndex = currentIndex - increment;
                }
            }
        }
    }
}
