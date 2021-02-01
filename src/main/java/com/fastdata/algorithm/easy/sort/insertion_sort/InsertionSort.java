package com.fastdata.algorithm.easy.sort.insertion_sort;

/**
 * @Author: Lucky
 * @Description: basic insertion sort in java
 * @Date: create in 1/20/21 - 12:16 PM
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // corner case
        if (arr.length <= 1 || arr == null) return;

        int length = arr.length;

        // 要插入的数字
        int insertNum;

        for (int i = 1; i < length; i ++) {
            insertNum = arr[i];
            // 已排好序的元素数量
            int j = i - 1;

            while (j >= 0 && arr[j] > insertNum) {
                // 从后向前循环，将大于insertNum的数向后移
                arr[j + 1] = arr[j];
                j --;
            }
            // 将要插入的数放在要插入的位置
            arr[j + 1] = insertNum;
        }
    }
}
