package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-time-visiting-all-points/
 * @Date: create in 1/5/21 - 11:20 AM
 */
public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = new int[][]{{3,2}, {-2, 2}};
        int ret = minTimeToVisitAllPoints(points);
        System.out.println("ret = " + ret);
    }

    private static int minTimeToVisitAllPoints(int[][] points) {
        /**
         * 基本思路：
         * points中两点是连续位置，同时最短时间为当前点与前一点x或y坐标相减的绝对值
         */
        int m = 0;
        int n = 1;
        if (points.length < 2) return -1;
        int ret = 0;
        while (n <= points.length - 1) {
            if (Math.abs(points[m][0] - points[n][0]) > Math.abs(points[m][1] - points[n][1])) {
                ret = ret + Math.abs(points[m][0] - points[n][0]);
            } else {
                ret = ret + Math.abs(points[m][1] - points[n][1]);
            }
            m ++;
            n ++;
        }
        return ret;
    }
}
