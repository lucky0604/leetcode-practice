package com.fastdata.algorithm.solutions.ch02;

/**
 * @Author: Lucky
 * @Description:
 * @Date: created in 2021/3/28 - 13:02
 */
public class ShellSortImpl_2_1_11 {

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
}
