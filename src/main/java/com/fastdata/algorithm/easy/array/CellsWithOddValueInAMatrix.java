package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * @Date: create in 1/5/21 - 11:49 AM
 */
public class CellsWithOddValueInAMatrix {
    public static void main(String[] args) {

    }

    private static int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix = addRow(matrix, indices[i][0]);
            matrix = addColumn(matrix, indices[i][1]);
        }
        int count = 0;
        for (int j = 0; j < n; j ++) {
            for (int k = 0; k < m; k ++) {
                if (matrix[j][k] % 2 != 0) {
                    count ++;
                }
            }
        }
        return count;
    }

    private static int[][] addRow(int[][] matrix, int index) {
        /**
         * 计算行
         */
        for (int i = 0; i < matrix[0].length; i ++) {
            matrix[index][i] ++;
        }
        return matrix;
    }

    private static int[][] addColumn(int[][] matrix, int index) {
        /**
         * 计算列
         */
        for (int i = 0; i < matrix.length; i ++) {
            matrix[i][index] ++;
        }
        return matrix;
    }
}
