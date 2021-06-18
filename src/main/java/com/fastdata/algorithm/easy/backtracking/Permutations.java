package com.fastdata.algorithm.easy.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/17/21 10:26 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/permutations/
 **/

public class Permutations {

    private static List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<>();
        backtracking(nums, tmp);
        return ret;
    }

    private static void backtracking(int[] nums, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ret.add(new LinkedList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            backtracking(nums, tmp);
            tmp.removeLast();
        }
    }
}
