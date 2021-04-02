package com.fastdata.algorithm.solutions.ch02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/2/21 - 12:45 PM
 */
// TODO: to be understand
public class Solution_2_1_29 {

    private static int[] threePlus1IncrementSequence;
    private static int[] customIncrementSequence;

    private enum IncrementType {
        ThreePlusOneIncrement,
        CustomIncrement
    }

    public static void main(String[] args) {
        int initArrLength = 32768;
        int numberOfExperiments = 10;
        int maxSize = initArrLength;
        for (int i = 0; i < numberOfExperiments - 1; i ++) {
            maxSize *= 2;
        }

        generateThreePlusOneIncrementSequence(maxSize);
        generateCustomIncrementSequence(maxSize);
        timeRandomInput(initArrLength, numberOfExperiments);
    }

    private static void timeRandomInput(int initLength, int numberOfExperiments) {
        int length = initLength;

        for (int experiment = 0; experiment < numberOfExperiments; experiment ++) {
            Comparable[] arr = new Comparable[length];
            for (int i = 0; i < length; i ++) {
                arr[i] = StdRandom.uniform();
            }
            Comparable[] arrCopy = Arrays.copyOf(arr, arr.length);
            int[] incrementSequence3NPlus1 = getIncrementSequence(IncrementType.ThreePlusOneIncrement, arr.length);
            int[] incrementSequenceCustom = getIncrementSequence(IncrementType.CustomIncrement, arr.length);

            double time1 = time(arr, incrementSequence3NPlus1);
            double time2 = time(arr, incrementSequenceCustom);

            StdOut.printf("For an array of size %d: \n", length);
            StdOut.printf("3N + 1 sequence: %.1f \n", time1);
            StdOut.printf("Custom sequence: %.1f \n", time2);
            StdOut.println();
            length *= 2;
        }
    }

    private static void shellSort(Comparable[] arr, int[] incrementSequence) {
        for (int i: incrementSequence) {
            // h-sort the arr
            for (int j = i; j < arr.length; j ++) {
                int currentIndex = j;
                while (currentIndex >= i && arr[currentIndex].compareTo(arr[currentIndex - i])< 0) {
                    Comparable tmp = arr[currentIndex];
                    arr[currentIndex] = arr[currentIndex - i];
                    arr[currentIndex - i] = tmp;
                    currentIndex = currentIndex - i;
                }
            }
        }
    }

    public static double time(Comparable[] arr, int[] incrementSequence) {
        Stopwatch timer = new Stopwatch();
        shellSort(arr, incrementSequence);
        return timer.elapsedTime();
    }

    /**
     * generate the increment by array's length
     * @param maxSize
     */
    private static void generateThreePlusOneIncrementSequence(int maxSize) {
        int maxIncrement = 1;
        // increment sequence's size
        int numberOfIncrement = 1;
        while ((maxIncrement * 3 + 1) < maxSize) {
            maxIncrement = maxIncrement * 3;
            maxIncrement ++;
            numberOfIncrement ++;
        }

        threePlus1IncrementSequence = new int[numberOfIncrement];
        int index = 0;
        while (maxIncrement > 0) {
            // decresed by the step
            threePlus1IncrementSequence[index] = maxIncrement;
            maxIncrement --;
            maxIncrement = maxIncrement / 3;
            index ++;
        }
    }

    private static void generateCustomIncrementSequence(int maxSize) {
        int numberOfIncrement = 0;
        int incrementIndex = 0;
        int currentIncrementSet1 = (int) (9 * Math.pow(4, incrementIndex) - 9 * Math.pow(2, incrementIndex) + 1);
        // start with increment index + 2 as power to avoid negative values
        int currentIncrementSet2 = (int) (Math.pow(4, incrementIndex + 2) - 3 * Math.pow(2, incrementIndex + 2) + 1);

        while (currentIncrementSet1 < maxSize || currentIncrementSet2 < maxSize) {
            if (currentIncrementSet1 < maxSize) {
                numberOfIncrement ++;
            }
            if (currentIncrementSet2 < maxSize) {
                numberOfIncrement ++;
            }
            incrementIndex ++;
            currentIncrementSet1 = (int) (9 * Math.pow(4, incrementIndex) - 9 * Math.pow(2, incrementIndex) + 1);
            currentIncrementSet2 = (int) (Math.pow(4, incrementIndex + 2) - 3 * Math.pow(2, incrementIndex + 2) + 1);
        }
        if (numberOfIncrement == 0) customIncrementSequence = new int[]{};
        // generate array of increments
        customIncrementSequence = new int[numberOfIncrement];
        incrementIndex = 0;
        currentIncrementSet1 = (int) (9 * Math.pow(4, incrementIndex) - 9 * Math.pow(2, incrementIndex) + 1);
        currentIncrementSet2 = (int) (Math.pow(4, incrementIndex + 2) - 3 * Math.pow(2, incrementIndex + 2) + 1);

        for (int i = numberOfIncrement - 1; i >= 0; i --) {
            customIncrementSequence[i] = currentIncrementSet1;
            if (i - 1 < 0) {
                break;
            }
            customIncrementSequence[i - 1] = currentIncrementSet2;
            i --;
            incrementIndex ++;
            currentIncrementSet1 = (int) (9 * Math.pow(4, incrementIndex) - 9 * Math.pow(2, incrementIndex) + 1);
            currentIncrementSet2 = (int) (Math.pow(4, incrementIndex + 2) - 3 * Math.pow(2, incrementIndex + 2) + 1);
        }
    }

    private static int[] getIncrementSequence(IncrementType type, int arrSize) {
        int[] incrementSequence = null;
        if (type == IncrementType.ThreePlusOneIncrement) {
            incrementSequence = threePlus1IncrementSequence;
        } else if (type == IncrementType.CustomIncrement) {
            incrementSequence = customIncrementSequence;
        }

        if (incrementSequence == null) {
            return new int[]{};
        }

        int low = 0;
        int high = incrementSequence.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (incrementSequence[mid] > arrSize) {
                low = mid + 1;
            } else if (incrementSequence[mid] < arrSize) {
                high = mid - 1;
            } else if (incrementSequence[mid] == arrSize) {
                break;
            }
        }

        // check if still within the array bounds
        if (incrementSequence[mid] >= arrSize) {
            mid ++;
        }
        int[] ret = new int[incrementSequence.length - mid];
        int index = 0;
        for (int i = mid; i < incrementSequence.length; i ++) {
            ret[index] = incrementSequence[i];
            index ++;
        }
        return ret;
    }
}
