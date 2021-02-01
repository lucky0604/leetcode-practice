package com.fastdata.algorithm.easy.binary_search;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 12/16/20 - 1:04 PM
 */
public class CountNegatives {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3}, {-1,2,-4}};
        int result = countNegatives(arr);
        System.out.println("result = " + result);
    }

    /**
     * 暴力破解
     * @param grid
     * @return
     */
//    public static int countNegatives(int[][] grid) {
//        int result = 0;
//        for (int i = 0; i < grid.length; i ++) {
//            for (int j = 0; j < grid[i].length; j ++) {
//                if (grid[i][j] < 0) {
//                    result += 1;
//                }
//            }
//        }
//        return result;
//    }

    // ======================== functional solution ======================
    public static int countNegatives(int[][] grid) {
        return Arrays.stream(grid).mapToInt(ints -> (int) Arrays.stream(ints).filter(i -> i < 0).count()).sum();
    }
}
