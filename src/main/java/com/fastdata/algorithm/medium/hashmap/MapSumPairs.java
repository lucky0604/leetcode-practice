package com.fastdata.algorithm.medium.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/31/21 10:02 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/map-sum-pairs/
 **/

public class MapSumPairs {

    Map<String, Integer> map;

    public MapSumPairs() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        Set<String> set = map.keySet();

        for (int i = 0; i < prefix.length(); i ++) {
            Set<String> curr = new HashSet<>();
            for (String s: set) {
                if (s.length() > i && s.charAt(i) == prefix.charAt(i)) {
                    curr.add(s);
                }
            }
            if (curr.size() == 0) {
                return 0;
            }
            set = curr;
        }

        int ret = 0;
        for (String s: set) {
            ret += map.get(s);
        }
        return ret;
    }
}
