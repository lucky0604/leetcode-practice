package com.fastdata.algorithm.easy.hashtable;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/unique-number-of-occurrences/
 * @Date: create in 1/15/21 - 12:39 PM
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int uniqNum: arr) {
            // 循环数组，并将数组的值作为map的key存放到map中
            // 若map中存在该数的key，则将值+1
            if (map.containsKey(uniqNum)) {
                map.put(uniqNum, map.get(uniqNum) + 1);
            } else {
                // 否则初始化该key的值为1
                map.put(uniqNum, 1);
            }
        }
        for (int item: map.values()) {
            set.add(item);
        }
        if (set.size() == map.size()) {
            return true;
        } else {
            return false;
        }
    }

}
