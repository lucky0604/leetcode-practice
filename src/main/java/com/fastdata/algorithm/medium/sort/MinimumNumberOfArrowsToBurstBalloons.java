package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @Date: create in 3/30/21 - 10:14 AM
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrow = 1;      // 1 always be fired
        int arrowValue = points[0][1];  // fire arrow at point's end to cover max distance
        for (int i = 1; i < points.length; i ++) {
            int left = points[i][0];
            int right = points[i][1];
            // check whether the arrow can burst other balloons
            // if not fire arrow at the next point end value
            if (!(arrowValue >= left && arrowValue <= right)) {
                arrow ++;
                arrowValue = points[i][1];
            }
        }
        return arrow;
    }
}
