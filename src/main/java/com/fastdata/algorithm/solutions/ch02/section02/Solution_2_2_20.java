package com.fastdata.algorithm.solutions.ch02.section02;

/**
 * @author lucky
 * @Description
 * @Filename null.java
 * @create 2021-04-19 上午11:54
 */

public class Solution_2_2_20 {
    public static Comparable[] generateArray1() {
        Comparable[] array = new Comparable[10];
        array[0] = 10; //Correct index: 9
        array[1] = 9; //Correct index: 7
        array[2] = 8; //Correct index: 5
        array[3] = 7; //Correct index: 3
        array[4] = 6; //Correct index: 1
        array[5] = 5; //Correct index: 0
        array[6] = 6; //Correct index: 2
        array[7] = 7; //Correct index: 4
        array[8] = 8; //Correct index: 6
        array[9] = 9; //Correct index: 8
        return array;
    }

    public static Comparable[] generateArray2() {
        Comparable[] array = new Comparable[4];
        array[0] = 4; //Correct index: 3
        array[1] = 3; //Correct index: 2
        array[2] = 2; //Correct index: 1
        array[3] = 1; //Correct index: 0
        return array;
    }

    public static int[] indexSort(Comparable[] array) {
        int[] aux = new int[array.length];
        int[] indexSort = new int[array.length];
        for (int i = 0; i < array.length; i ++) {
            indexSort[i] = i;
        }
        indexSort(array, aux, indexSort, 0, array.length - 1);
        return indexSort;
    }

    public static void indexSort(Comparable[] array, int[] aux, int[] indexSort, int low, int high) {
        if (low <= high) return;
        int mid = low + (high - low) / 2;
        indexSort(array, aux, indexSort, 0, mid);
        indexSort(array, aux, indexSort, mid + 1, high);
        merge(array, aux, indexSort, low, mid, high);
    }

    public static void merge(Comparable[] array, int[] aux, int[] indexSort, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = indexSort[i];
        }

        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrayIndex = low;

        while (leftIndex <= mid && rightIndex <= high) {
            if (array[aux[leftIndex]].compareTo(array[aux[rightIndex]]) <= 0) {
                indexSort[arrayIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                indexSort[arrayIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrayIndex ++;
        }

        while (leftIndex <= mid) {
            indexSort[arrayIndex] = aux[leftIndex];
            leftIndex ++;
            arrayIndex ++;
        }
    }
}
