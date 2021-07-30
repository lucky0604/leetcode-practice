package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/30/21 10:39 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/01-matrix/
 **/

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int max = row + column - 2;
        int[][] ret = new int[row][column];
        // scan left to right, top to bottom
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j ++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if ((i - 1 >= 0 && mat[i - 1][j] == 0) || (j - 1 >= 0 && mat[i][j - 1] == 0)) {
                    ret[i][j] = 1;
                } else {
                    ret[i][j] = 1 + Math.min(i - 1 >= 0 ? ret[i - 1][j]: max, j - 1 >= 0 ? ret[i][j - 1]: max);
                }
            }
        }

        // scan bottom to top, right to left
        for (int i = row - 1; i >= 0; i --) {
            for (int j = column - 1; j >= 0; j --) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if ((i + 1 < row && mat[i + 1][j] == 0) || (j + 1 < column && mat[i][j + 1] == 0)) {
                    ret[i][j] = 1;
                } else {
                    int dist = 1 + Math.min(i + 1 < row ? ret[i + 1][j]: max, j + 1 < column ? ret[i][j + 1]: max);
                    // combine result
                    ret[i][j] = Math.min(ret[i][j], dist);
                }
            }
        }
        return ret;
    }
}
