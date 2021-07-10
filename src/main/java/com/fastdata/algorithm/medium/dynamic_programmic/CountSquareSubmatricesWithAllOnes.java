package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/4 13:56
 * @Version: 1.0
 * @description: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 **/

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] allOnes = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 1) {
                    allOnes[i][j] = 1;
                    if (i > 0 && j > 0) {
                        allOnes[i][j] += Math.min(allOnes[i - 1][j], Math.min(allOnes[i][j - 1], allOnes[i - 1][j - 1]));
                    }
                    count += allOnes[i][j];
                }
            }
        }
        return count;
    }
}
