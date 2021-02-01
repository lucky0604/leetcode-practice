package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/flipping-an-image/
 * @Date: create in 1/26/21 - 11:14 AM
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0}, {1,0,1}, {0,0,0}};
        int[][] ret = flipAndInvertImage(A);
        for (int i = 0; i < ret.length; i ++) {
            System.out.println(Arrays.toString(A[i]));
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        // create an inversion array
        int[] invert = new int[2];
        invert[0] = 1;
        invert[1] = 0;
        for (int i = 0; i < A.length; i ++) {
            int start = 0;
            int end = A[i].length - 1;
            while (start < end) {
                int temp = A[i][start];
                A[i][start ++] = invert[A[i][end]];
                A[i][end --] = invert[temp];
            }

            if (start == end) {
                A[i][start] = invert[A[i][start]];
            }
        }
        return A;
    }
}
