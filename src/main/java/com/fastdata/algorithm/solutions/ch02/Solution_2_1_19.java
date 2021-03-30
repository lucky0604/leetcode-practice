package com.fastdata.algorithm.solutions.ch02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.StringJoiner;

/**
 * @Author: Lucky
 * @Description: Shellsort worst case
 * Construct an array of 100 elements containing the numbers 1 through 100 for which shellsort, with the increments 1 4 13 40, uses as large a
 * number of compares as you can find.
 * @Date: create in 3/30/21 - 10:58 AM
 */
public class Solution_2_1_19 {

    public static void main(String[] args) {
        Integer[] worstCaseArr = findWorstCaseInput();
        printArray(worstCaseArr);
    }

    private static class ShellSortWithCompareCount {
        private int comparesCount;

        private void shellSort(Comparable[] arr) {
            comparesCount = 0;
            int incrementSequence = 1;

            while (incrementSequence * 3 + 1 < arr.length) {
                incrementSequence *= 3;
                incrementSequence ++;
            }
            while (incrementSequence > 0) {
                for (int i = incrementSequence; i < arr.length; i ++) {
                    for (int j = i; j >= incrementSequence; j-= incrementSequence) {
                        comparesCount ++;
                        if (arr[j].compareTo(arr[j - incrementSequence]) < 0) {
                            Comparable tmp = arr[j];
                            arr[j] = arr[j - incrementSequence];
                            arr[j - incrementSequence] = tmp;
                        } else {
                            break;
                        }
                    }
                }
                incrementSequence /= 3;
            }
        }

        public int getComparesCount() {
            return comparesCount;
        }
    }

    private static Integer[] findWorstCaseInput() {
        Integer[] worstCaseArray = null;
        int highestNumberOfCompares = 0;
        ShellSortWithCompareCount shellSort = new ShellSortWithCompareCount();

        for (int i = 0; i < 100000000; i ++) {
            Integer[] arr = generateRandomArray();
            Integer[] arrCopy = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCopy, 0, arr.length);
            shellSort.shellSort(arr);
            if (shellSort.getComparesCount() > highestNumberOfCompares) {
                worstCaseArray = arrCopy;
                highestNumberOfCompares = shellSort.getComparesCount();
            }
        }

        StdOut.println("Highest number of compares: " + highestNumberOfCompares);
        return worstCaseArray;
    }

    private static Integer[] generateRandomArray() {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = i + 1;
        }
        StdRandom.shuffle(arr);
        return arr;
    }
    private static void printArray(Integer[] arr) {
        StringJoiner arrDesc = new StringJoiner(" ");
        for (int a: arr) {
            arrDesc.add(String.valueOf(a));
        }
        StdOut.println(arrDesc);
    }
}
