package com.fastdata.algorithm.solutions.ch02;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/1/21 - 12:29 PM
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int j;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i ++) {
                int tmp = arr[i];
                for (j = i; j >= step && tmp < arr[j - step]; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = tmp;
            }
        }
    }

    public static void shellSort(Comparable[] arr) {
        int length = arr.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i ++) {
                int j = i;
                Comparable tmp = arr[j];
                while (j - step >= 0 && arr[j - step].compareTo(tmp) > 0) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = tmp;
            }
        }
    }
}
