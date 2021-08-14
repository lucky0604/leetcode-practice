package com.fastdata.algorithm.medium.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/14/21 10:03 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/set-matrix-zeroes/
 **/

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            if (row.contains(i)) {
                for (int j = 0; j < m; j ++) {
                    matrix[i][j] = 0;
                }
            } else {
                for (int j = 0; j < m; j ++) {
                    if (col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return;

    }
}
