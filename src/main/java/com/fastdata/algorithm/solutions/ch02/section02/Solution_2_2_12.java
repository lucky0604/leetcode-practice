package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Solution_2_2_12
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/13/21 11:54 AM
 */

public class Solution_2_2_12 {

    public static void main(String[] args) {
        int arrLength = 64;
        int blocks = 4;

//        if (arrLength % blocks != 0) {
//            throw new RuntimeException("Array size needs to be a multiple of block size");
//        }
        Comparable[] arr = generateRandomArray(arrLength);
        selectionSortBlocks(arr, blocks);
        Comparable[] aux = new Comparable[arrLength];
        for (int i = arrLength / blocks - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                int low = j * blocks;
                int mid = (j + 1) * blocks - 1;
                int high = mid + blocks;
                merge(arr, aux, low, mid, high);
            }
        }
    }

    private static Comparable[] generateRandomArray(int arrLength) {
        Comparable[] arr = new Comparable[arrLength];
        for (int i = 0; i < arrLength; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    private static void selectionSortBlocks(Comparable[] arr, int blocks) {
        for (int i = 0; i < arr.length; i += blocks) {
            selectionSort(arr, i, i + blocks - 1);
        }
    }

    private static void selectionSort(Comparable[] arr, int low, int high) {
        for (int i = low; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j <= high; j ++) {
                if (arr[minIndex].compareTo(arr[j]) < 0) {
                    minIndex = j;
                }
            }
            Comparable tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        int auxIndex = 0;

        for (int i = low; i <= mid; i ++) {
            aux[auxIndex] = arr[i];
            auxIndex ++;
        }

        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrIndex = low;

        while (leftIndex < aux.length && rightIndex <= high) {
            if (aux[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                arr[arrIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                arr[arrIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrIndex ++;
        }

        while (leftIndex < aux.length) {
            arr[arrIndex] = aux[leftIndex];
            leftIndex ++;
            arrIndex ++;
        }
    }
}
