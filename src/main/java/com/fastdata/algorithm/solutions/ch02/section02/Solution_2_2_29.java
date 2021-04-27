package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 4/27/21 1:56 PM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_2_29 {

    public static void main(String[] args) {
        List<Long[]> arrays = new ArrayList<>(4);
        Long[] array1 = generateLongArray(1000);
        Long[] array2 = generateLongArray(2000);
        Long[] array3 = generateLongArray(3000);
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        doExperiments(arrays);
    }

    private static Long[] generateLongArray(int length) {
        Long[] array = new Long[length];
        Random random = new Random();
        for (int i = 0; i < length; i ++) {
            array[i] = random.nextLong();
        }

        return array;
    }

    private static void doExperiments(List<Long[]> arrays) {
        int numberOfExperiments = arrays.size();
        for (int i = 0; i < numberOfExperiments; i ++) {
            Long[] currentArray = arrays.get(i);
            long numberOfPasses = naturalMergeSort(currentArray);
            StdOut.printf("Number of passes needed for an array of %d random Long keys: %d \n", currentArray.length,
                    numberOfPasses);
        }
    }

    private static int naturalMergeSort(Long[] array) {
        int numberOfPasses = 1;

        if (array == null || array.length == 1) {
            return numberOfPasses;
        }

        Comparable[] aux = new Comparable[array.length];

        int low = 0;
        int mid = 0;
        int high = 0;

        boolean secondSubArray = false;

        for (int i = 1; i < array.length; i ++) {
            if (!secondSubArray) {
                mid = i - 1;
                secondSubArray = true;
                numberOfPasses ++;
            } else {
                high = i - 1;
                BottomUpMergeSort.merge(array, aux, low, mid, high);
                mid = high;
                numberOfPasses ++;
            }
        }
        if (high != array.length - 1) {
            BottomUpMergeSort.merge(array, aux, low, mid, array.length - 1);
            numberOfPasses ++;
        }
        return numberOfPasses;
    }
}
