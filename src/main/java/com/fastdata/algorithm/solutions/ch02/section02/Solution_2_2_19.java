package com.fastdata.algorithm.solutions.ch02.section02;

import java.util.Arrays;

/**
 * @ClassName: Solution_2_2_19
 * @Description: explanation: https://www.geeksforgeeks.org/counting-inversions/
 * @Create by: lucky
 * @Date: 4/16/21 12:22 PM
 */

public class Solution_2_2_19 {

    public static Comparable[] generateArray() {
        Comparable[] array = new Comparable[10];
        array[0] = 10;
        array[1] = 9;
        array[2] = 8;
        array[3] = 7;
        array[4] = 6;
        array[5] = 5;
        array[6] = 6;
        array[7] = 7;
        array[8] = 8;
        array[9] = 9;
        return array;
    }

    public static Comparable[] generateArray2() {
        Comparable[] array = new Comparable[4];
        array[0] = 4;
        array[1] = 3;
        array[2] = 2;
        array[3] = 1;
        return array;
    }

    public static int countInversions(Comparable[] array) {
        Comparable[] copy = Arrays.copyOf(array, array.length);
        Comparable[] aux = new Comparable[copy.length];
        return splitArrayAndCountInversions(copy, aux, 0, array.length - 1);
    }

    public static int splitArrayAndCountInversions(Comparable[] array, Comparable[] aux, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int inversions = splitArrayAndCountInversions(array, aux, low, mid);
        inversions += splitArrayAndCountInversions(array, aux, mid + 1, high);
        return inversions + countInversionsComparingBothParts(array, aux, low, mid, high);
    }

    // use merge sort for counting the inversions
    private static int countInversionsComparingBothParts(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = array[i];
        }

        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrIndex = low;

        int inversions = 0;

        while (leftIndex <= mid && rightIndex <= high) {
            if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                array[arrIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                inversions += mid - leftIndex + 1;
                array[arrIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrIndex ++;
        }
        while (leftIndex <= mid) {
            array[arrIndex] = aux[leftIndex];
            leftIndex ++;
            arrIndex ++;
        }
        return inversions;
    }
}
