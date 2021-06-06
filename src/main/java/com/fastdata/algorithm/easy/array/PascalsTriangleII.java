package com.fastdata.algorithm.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-06 7:50 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/pascals-triangle-ii/
 **/

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        int[][] triangle = new int[rowIndex + 1][ rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (j == i || j == 0) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        for (int i = 0; i < triangle[rowIndex].length; i ++) {
            ret.add(triangle[rowIndex][i]);
        }
        return ret;
    }
}
