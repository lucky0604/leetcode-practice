package com.fastdata.algorithm.medium.array;

import java.util.*;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/12/21 10:04 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/array-of-doubled-pairs/
 **/

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // count map
        for (int n: arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // create a sorted list of all unique elements, sort by absolute value
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (int n: list) {
            int count = map.get(n);
            // this means the number was already matched in a previous iteration
            if (count == 0) {
                continue;
            }

            int pairCount = map.getOrDefault(2 * n, 0);
            // if the number's count is greater than that of its pair, then some copies of it will remain unmatched
            if (count > pairCount) {
                return false;
            }

            // update the count of the pair
            map.put(2 * n, pairCount - count);
        }

        return true;
    }
}
