package com.fastdata.algorithm.solutions.ch02.section01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/1/21 - 12:44 PM
 */
public class Solution_2_1_27 {

    public static void main(String[] args) {
        compareSort();
    }

    private static void compareSort() {
        int arrLength = 128;
        int numberOfExperiment = 11;

        double timeSelectionSort = timeRandomInput(SortType.SELECTION, arrLength, numberOfExperiment);
        double timeInsertionSort = timeRandomInput(SortType.INSERTION, arrLength, numberOfExperiment);
        double timeShellSort = timeRandomInput(SortType.SHELL, arrLength, numberOfExperiment);

        StdOut.printf("Shell sort is %.1f times faster than Selection sort", timeSelectionSort / timeShellSort);
        StdOut.println();
        StdOut.printf("Shell sort is %.1f times faster than Insertion sort", timeInsertionSort / timeShellSort);
    }

    public static double timeRandomInput(SortType sortType, int initialLength, int numberOfExperiments) {
        double total = 0;
        int length = initialLength;
        for (int experiment = 0; experiment < numberOfExperiments; experiment ++) {
            Comparable[] arr = new Comparable[length];
            for (int i = 0; i < length; i ++) {
                arr[i] = StdRandom.uniform();
            }
            total += time(sortType, arr);
            length *= 2;
        }
        return total;
    }

    public static double time(SortType sortType, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        if (sortType == SortType.INSERTION) {
            InsertionSort.insertionSort(arr);
        } else if (sortType == SortType.SELECTION) {
            SelectionSort.selectionSort(arr);
        } else if (sortType == SortType.SHELL) {
            ShellSort.shellSort(arr);
        }
        return timer.elapsedTime();
    }
}
