package com.fastdata.algorithm.medium.backtracking;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/4/21 10:17 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/subsets-ii/
 **/

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(nums, start, l, ret);
        return ret;
    }

    private void backtracking(int[] nums, int start, List<Integer> l, List<List<Integer>> ret) {
        ret.add(new ArrayList<>(l));
        for (int i = start; i < nums.length; i ++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            l.add(nums[i]);
            backtracking(nums, i + 1, l, ret);
            l.remove(l.size() - 1);
        }
    }
}
