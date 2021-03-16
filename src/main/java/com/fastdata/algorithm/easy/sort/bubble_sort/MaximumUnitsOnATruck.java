package com.fastdata.algorithm.easy.sort.bubble_sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-units-on-a-truck/
 * @Date: create in 3/16/21 - 12:02 PM
 */
public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // bubble sort first
        /**
         * base on the rule:
         * sort the 2D array by the value
         */
        for (int i = 0; i < boxTypes.length - 1; i ++) {
            for (int j = 0; j < boxTypes.length - 1 - i; j ++) {
                if (boxTypes[j][1] < boxTypes[j + 1][1]) {
                    int[] temp = boxTypes[j];
                    boxTypes[j] = boxTypes[j + 1];
                    boxTypes[j + 1] = temp;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < boxTypes.length; i ++) {
            if (truckSize > boxTypes[i][0]) {
                sum += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else if (truckSize <= boxTypes[i][0]) {
                sum += truckSize * boxTypes[i][1];
                break;
            }
        }
        return sum;
    }
}
