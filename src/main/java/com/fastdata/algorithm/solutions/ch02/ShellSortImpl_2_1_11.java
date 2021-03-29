package com.fastdata.algorithm.solutions.ch02;

/**
 * @Author: Lucky
 * @Description:
 * 2.1.11:
 * Implement a version of shellsort that keeps the increment sequence in an array,
 * rather than computing it.
 * @Date: created in 2021/3/28 - 13:02
 */
public class ShellSortImpl_2_1_11 {

    /**
     * Normal shell sort
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int length = arr.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i ++) {
                int j = i;
                int tmp = arr[j];
                while (j - step >= 0 && arr[j - step] > tmp) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = tmp;
            }
        }
    }

    private static void customShellSort(int[] arr) {
        // corner case
        if (arr == null || arr.length == 0) return;

        // store the increment in an array
        int maxIncrement = 1;
        int numberOfIncrements = 1;
        while ((maxIncrement * 3) + 1 < arr.length) {
            maxIncrement = maxIncrement * 3;
            maxIncrement ++;
            numberOfIncrements ++;
        }

        int[] incrementSequence = new int[numberOfIncrements];
        int index = 0;
        while (maxIncrement > 0) {
            incrementSequence[index] = maxIncrement;
            maxIncrement --;
            maxIncrement = maxIncrement / 3;
            index ++;
        }

        // sort
        for (int i = 0; i < incrementSequence.length; i ++) {
            int increment = incrementSequence[i];

            // h-sort the arr
            for (int j = increment; j < arr.length; j ++) {
                int curr = j;
                while (curr >= increment && arr[curr] < arr[curr - increment]) {
                    int tmp = arr[curr];
                    arr[curr] = arr[curr - increment];
                    arr[curr - increment] = tmp;
                    curr = curr - increment;
                }
            }
        }
    }
}
