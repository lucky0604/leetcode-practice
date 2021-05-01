package com.fastdata.algorithm.solutions.ch02.section03;

import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Map;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/5/1 - 12:48
 */
public class Solution_2_3_07 {

    private static int subArraySize0;
    private static int subArraySize1;
    private static int subArraySize2;

    public static void main(String[] args) {
        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(5, 1000, 2);
        StdOut.printf("%13s %17s %17s %17s\n", "Array Size | ", "SubArrays Size 0 | ", "SubArrays Size 1 | ", "SubArrays Size 2");

        for (int i = 0; i < allInputArrays.size(); i ++) {
            Comparable[] array = allInputArrays.get(i);
            quickSort(array);
            printResults(array.length);

            subArraySize0 = 0;
            subArraySize1 = 0;
            subArraySize2 = 0;
        }
    }

    private static void quickSort(Comparable[] array) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (low >= high) return;

        int partition = partition(array, low, high);

        // size = high - low + 1
        int leftSubArraySize = partition - low;
        int rightSubArraySize = high - partition;
        checkSubArraySize(leftSubArraySize);
        checkSubArraySize(rightSubArraySize);

        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private static void checkSubArraySize(int subArraySize) {
        if (subArraySize == 0) {
            subArraySize0 ++;
        } else if (subArraySize == 1) {
            subArraySize1 ++;
        } else if (subArraySize == 2) {
            subArraySize2 ++;
        }
    }

    private static int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;

        while (true) {
            while (ArrayUtil.less(array[++ i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (ArrayUtil.less(pivot, array[ -- j])) {
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

    private static void printResults(int arraySize) {
        StdOut.printf("%10d %19d %19d %20d\n", arraySize, subArraySize0, subArraySize1, subArraySize2);
    }
}
