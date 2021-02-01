package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/matrix-diagonal-sum/
 * @Date: create in 1/26/21 - 10:28 AM
 */
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int ret = diagonalSum(mat);
        System.out.println(ret);
    }

    public static int diagonalSum(int[][] mat) {
        int ret = 0;
        // two pointers
        for (int i = 0, j = mat.length - 1; i < mat.length && j >= 0; i ++, j --) {
            ret += mat[i][i];
            if (i != j) {
                ret += mat[i][j];
            }
        }
        return ret;
    }
}
