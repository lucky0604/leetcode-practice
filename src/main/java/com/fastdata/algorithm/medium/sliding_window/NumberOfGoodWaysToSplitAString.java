package com.fastdata.algorithm.medium.sliding_window;

import java.util.HashMap;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/9/21 9:57 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 **/

public class NumberOfGoodWaysToSplitAString {

    public int numSplits(String s) {
        int count = 0;
        char[] charArr = s.toCharArray();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        map1.put(charArr[0], 1);

        for (int i = 1; i <charArr.length; i ++) {
            map2.put(charArr[i], map2.getOrDefault(charArr[i], 0) + 1);
        }

        if (map1.keySet().size() == map2.keySet().size()) {
            count ++;
        }

        // sliding window
        for (int i = 1; i < charArr.length; i ++) {
            map1.put(charArr[i], map1.getOrDefault(charArr[i], 0) + 1);

            map2.put(charArr[i], map2.get(charArr[i]) - 1);
            map2.values().removeIf(value -> value == 0);
            if (map1.keySet().size() == map2.keySet().size()) {
                count ++;
            }
        }

        return count;
    }
}
