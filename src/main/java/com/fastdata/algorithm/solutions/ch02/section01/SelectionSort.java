package com.fastdata.algorithm.solutions.ch02.section01;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/1/21 - 12:16 PM
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Comparable tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }
}
