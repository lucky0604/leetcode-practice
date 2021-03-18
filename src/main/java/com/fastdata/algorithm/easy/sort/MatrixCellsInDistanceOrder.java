package com.fastdata.algorithm.easy.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/matrix-cells-in-distance-order/
 * @Date: create in 3/18/21 - 11:38 AM
 */
public class MatrixCellsInDistanceOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int [][] ret = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j ++) {
                ret[index][0] = i;
                ret[index][1] = j;
                index ++;
            }
        }

        Arrays.sort(ret, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0)));

        return ret;
    }
}
