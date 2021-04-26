package com.fastdata.algorithm.solutions.ch02.section02;

import com.fastdata.algorithm.utils.ArrayGenerator;
import edu.princeton.cs.algs4.StdOut;

import java.util.Map;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_27
 * @create 2021-04-25 上午11:45
 */

public class Solution_2_2_27 {

    private double totalNumberOfSubArrays;
    private double totalSubArrayProportion;

    public static void main(String[] args) {
        int numberOfExperiments = 8;
        int initialArraySize = 131072;

        Solution_2_2_27 subarrayLengths = new Solution_2_2_27();
        Map<Integer, Comparable[]> allInputArrays = ArrayGenerator.generateAllArrays(numberOfExperiments, initialArraySize, 2);
        subarrayLengths.doExperiment(numberOfExperiments, initialArraySize, allInputArrays);
    }

    private void doExperiment(int numberOfExperiments, int initialArraySize, Map<Integer, Comparable[]> allInputArrays) {
        StdOut.printf("%13s %28s\n", "Array Size | ", "AVG Length of other SubArray(%)");

        int arraySize = initialArraySize;

        for (int i = 0; i < numberOfExperiments; i ++) {
            totalNumberOfSubArrays = 0;
            totalSubArrayProportion = 0;

            Comparable[] array = allInputArrays.get(i);
            mergeSort(array);

            double averageLengthOfOtherSubArray = totalSubArrayProportion / totalNumberOfSubArrays * 100;
            StdOut.printf("%10d %31.1f\n", arraySize, averageLengthOfOtherSubArray);

            arraySize += 2;
        }
    }

    private void mergeSort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private void mergeSort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, aux, low, mid);
        mergeSort(array, aux, mid + 1, high);

        merge(array, aux, low, mid, high);
    }

    private void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        totalNumberOfSubArrays  ++;

        for (int i = low; i <= high; i ++) {
            aux[i] = array[i];
        }

        int leftIndex = low;
        int rightIndex = mid + 1;

        boolean exhaused = false;

        for (int i = low; i <= high; i ++) {
            if (leftIndex > rightIndex) {
                array[i] = aux[rightIndex];
                rightIndex ++;
            } else if (rightIndex > high) {
                array[i] = aux[leftIndex];
                leftIndex ++;
            } else if (aux[leftIndex].compareTo(aux[rightIndex]) <= 0) {
                array[i] = aux[leftIndex];
                leftIndex ++;
            } else {
                array[i] = aux[rightIndex];
                rightIndex ++;
            }

            if (!exhaused && (leftIndex > mid || rightIndex > high)) {
                exhaused = true;
                double lengthOfOtherSubArray = 0;

                if (leftIndex > mid) {
                    lengthOfOtherSubArray += high - rightIndex + 1;
                } else {
                    lengthOfOtherSubArray += mid - leftIndex + 1;
                }

                double lengthOfBothSubArrays = high - low + 1;
                double proportionOfSubArrayOverArray = lengthOfOtherSubArray / lengthOfBothSubArrays;
                totalSubArrayProportion += proportionOfSubArrayOverArray;
            }
        }
    }

}
