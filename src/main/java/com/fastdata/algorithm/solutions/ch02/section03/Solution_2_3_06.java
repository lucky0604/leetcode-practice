package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 4/30/21 10:43 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_3_06 {

    private static int numberOfCompares;

    public static void main(String[] args) {
        int[] arraySizes = {100, 1000, 10000};

        StdOut.printf("%13s %12s %17s\n", "Array size | ", "Compares | ", "Expected Compares");

        for (int i = 0; i < arraySizes.length; i ++) {
            int arraySize = arraySizes[i];
            Comparable[] arr = ArrayGenerator.generateRandomArray(arraySize);
            quickSort(arr);

            double lnN = Math.log(arraySize);

            // 2N ln N
            double numberOfExpectedCompares = 2 * arraySize * lnN;
            printResults(arraySize, numberOfCompares, numberOfExpectedCompares);
            numberOfCompares = 0;
        }
    }

    private static void quickSort(Comparable[] array) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int partition = partitions(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private static int partitions(Comparable[] array, int low, int high) {
        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;

        while (true) {
            numberOfCompares ++;

            while (ArrayUtil.less(array[++ i], pivot)) {
                if (i == high) {
                    break;
                }
                numberOfCompares ++;
            }
            numberOfCompares ++;
            while (ArrayUtil.less(pivot, array[-- j])) {
                if (j == low) {
                    break;
                }
                numberOfCompares ++;
            }

            if (i >= j) {
                break;
            }
            ArrayUtil.exchange(array, i, j);
        }

        ArrayUtil.exchange(array, low, j);
        return j;
    }

    private static void printResults(int arraySize, int numberOfCompares, double numberOfExpectedCompares) {
        StdOut.printf("%10d %12d %20.0f\n", arraySize, numberOfCompares, numberOfExpectedCompares);
    }
}
