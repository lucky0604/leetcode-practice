package com.fastdata.algorithm.medium.array;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/2/21 11:37 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/majority-element-ii/
 **/

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> obj: map.entrySet()) {
            if (obj.getValue() > length / 3) {
                ret.add(obj.getKey());
            }
        }
        return ret;
    }
}
