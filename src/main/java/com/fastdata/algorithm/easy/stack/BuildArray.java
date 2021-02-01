package com.fastdata.algorithm.easy.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/build-an-array-with-stack-operations/
 * @Date: create in 12/22/20 - 1:19 PM
 */
public class BuildArray {
    public static void main(String[] args) {
        buildArray(new int[]{1,2,3,5}, 5);
    }

    public static List<String> buildArray(int[] target, int n) {
        /**
         * 基本思路：
         * 1，给定列表一定是从1开始递增的列表
         * 2，
         */
        List<String> result = new ArrayList<>();
        int idx = 0;
        int len = target.length;
        for (int i = 1; i <= n; i ++) {
            if (idx >= len) {
                break;
            }
            if (i == target[idx]) {
                result.add("Push");
                idx ++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        System.out.println("result = " + result);
        return result;
    }
}
