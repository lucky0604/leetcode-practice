package com.fastdata.algorithm.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/xor-operation-in-an-array/
 * @Date: create in 12/29/20 - 11:46 AM
 */
// TODO: to be understand ^ operation
public class XOROperationInAnArray {
    public static void main(String[] args) {
        int n = 4;
        int start = 3;
        int ret = xorOperation(n, start);
        System.out.println("ret = " + ret);
    }

    private static int xorOperation(int n, int start) {
        int[] res = new int[n];
        int ret = 0;
        if (n > 1) {
            for (int i = 0; i < n; i ++) {
                res[i] = start;
                start += 2;
            }
            System.out.println("res = " + Arrays.toString(res));
            for (int i = 0; i < res.length; i ++) {
                if (i == 0) {
                    ret = res[i];
                } else {
                    ret = ret ^ res[i];
                }

            }
        } else {
            return start;
        }
        return ret;
    }
}
