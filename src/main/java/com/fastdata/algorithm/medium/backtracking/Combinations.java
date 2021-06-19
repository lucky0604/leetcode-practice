package com.fastdata.algorithm.medium.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/16/21 10:37 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/combinations/
 **/
// TODO: to be understand
public class Combinations {

    private int[] tmp;

    public List<List<Integer>> combine(int n, int k) {
        tmp = new int[k];
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(ret, n, 1, k);
        return ret;
    }

    private void backtracking(List<List<Integer>> ret, int n, int index, int k) {
        if (index == k + 1) {
            List<Integer> subList = new ArrayList<>();
            for (int i: tmp) {
                subList.add(i);
            }
            ret.add(subList);
            return;
        }

        int curr = (index == 1) ? 1: tmp[index - 2] + 1;
        for (int i = curr; i <= n; i ++) {
            tmp[index - 1] = i;
            backtracking(ret, n, index + 1, k);
        }
    }
}
