package com.fastdata.algorithm.medium.sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * @Date: create in 3/19/21 - 12:11 PM
 */
// TODO: to be understand
public class SortTheMatrixDiagonally {


    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // all diagonal start from (1, 0), (2, 0), .., (m - 1, 0)
        for (int i = 1; i < m; i ++) {
            int[] bound = m > i + n ? new int[]{i + n - 1, n - 1} : new int[]{m - 1, m - i - 1};
            quicksort(mat, new int[]{i, 0}, bound);
        }
        // diagonal start from (0, 0)
        quicksort(mat, new int[]{0, 0}, new int[]{Math.min(m, n) - 1, Math.min(m, n) - 1});
        // diagonal start from (0, 1), (0, 2), ..., (0, n - 1)
        for (int j = 1; j < n; j ++) {
            int[] bound = n > j + m ? new int[]{m - 1, j + m - 1}: new int[]{n - j - 1, n - 1};
            quicksort(mat, new int[]{0, j}, bound);
        }
        return mat;
    }

    private void quicksort(int[][] mat, int[] lo, int[] hi) {
        if (!valid(mat, lo) || !valid(mat, hi) || lo[0] >= hi[0]) return;
        int[] mi = partition(mat, lo, hi);
        quicksort(mat, lo, new int[]{mi[0] - 1, mi[1] - 1});
        quicksort(mat, new int[]{mi[0] + 1, mi[1] + 1}, hi);
    }

    private int[] partition(int[][] mat, int[] low, int[] high) {
        int[] lo = low.clone();
        int[] hi = high.clone();
        int target = mat[low[0]][low[1]];
        int m = mat.length;
        int n = mat[0].length;
        while (lo[0] < hi[0]) {
            while (lo[0] < hi[0] && mat[hi[0]][hi[1]] > target) {
                hi[0] --;
                hi[1] --;
            }
            if (lo[0] < hi[0]) mat[lo[0] ++][lo[1] ++] = mat[hi[0]][hi[1]];
            while (lo[0] < hi[0] && mat[lo[0]][lo[1]] <= target) {
                lo[0] ++;
                lo[1] ++;
            }
            if (lo[0] < hi[0]) mat[hi[0]--][hi[1] --] = mat[lo[0]][lo[1]];
        }
        mat[lo[0]][lo[1]] = target;
        return lo;
    }

    // check the matrix if it is valid
    private boolean valid(int[][] mat, int[] pos) {
        int m = mat.length;
        int n = mat[0].length;
        return pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n;
    }
}
