package com.fastdata.algorithm.medium.sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 * @Date: create in 3/19/21 - 11:12 AM
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        // sort by x coordinate
        // selection sort
        int length = points.length;
        for (int i = 0; i < length - 1; i ++) {
            int minArrIndex = i;
            for (int j = i + 1; j < length; j ++) {
                if (points[j][0] < points[minArrIndex][0]) {
                    minArrIndex = j;
                }
            }
            int[] tempArr = points[i];
            points[i] = points[minArrIndex];
            points[minArrIndex] = tempArr;
        }
        int result = 0;
        for (int i = 0; i < length - 1; ++ i) {
            result = Math.max(result, points[i][0] - points[i + 1][0]);
        }
        return result;
    }
}
