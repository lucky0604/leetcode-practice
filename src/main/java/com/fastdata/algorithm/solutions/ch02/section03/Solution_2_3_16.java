package com.fastdata.algorithm.solutions.ch02.section03;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/5/3 - 21:25
 */
public class Solution_2_3_16 {

    public static void main(String[] args) {
        int arraySize = 10;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] array = bestCaseArray(arraySize);
        StdOut.print("Best-case array: ");
        for (int i = 0; i < arraySize; i ++) {
            StdOut.print(alphabet.charAt(array[i]));
        }
        StdOut.println();
    }

    private static int[] bestCaseArray(int arraySize) {
        int[] bestCaseArray = new int[arraySize];
        for (int i = 0; i <bestCaseArray.length; i ++) {
            bestCaseArray[i] = i;
        }
        bestCaseArray(bestCaseArray, 0, arraySize - 1);
        return bestCaseArray;
    }

    private static void bestCaseArray(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        bestCaseArray(array, low, mid - 1);
        bestCaseArray(array, mid + 1, high);
        int tmp = array[low];
        array[low] = array[mid];
        array[mid] = tmp;
    }
}
