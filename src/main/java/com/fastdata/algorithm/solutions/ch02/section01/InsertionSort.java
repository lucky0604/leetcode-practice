package com.fastdata.algorithm.solutions.ch02.section01;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/1/21 - 12:06 PM
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (arr[j] > arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i; j > 0 && arr[j - 1].compareTo(arr[j]) > 0; j --) {
                Comparable tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }

    public static void insertionSort(Comparable[] arr, int low, int high) {
        for (int i = low; i <= high; i ++) {
            for (int j = i; j > 0 && ArrayUtil.more(arr[j - 1], arr[j]); j --) {
                Comparable tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }
}
