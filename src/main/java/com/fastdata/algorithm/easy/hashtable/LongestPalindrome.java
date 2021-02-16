package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/longest-palindrome/
 * @Date: created in 2021/2/16 - 11:33
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        boolean flag = false;

        if (s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i ++) {
            map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
        }
        int sum = 0;
        for (Character c: map.keySet()) {
            int val = map.get(c);
            if (val % 2 == 0) {
                sum += val;
            } else {
                if (flag == false) {
                    // first odd characters
                    sum += val;
                    flag = true;
                } else {
                    sum += (val - 1);
                }
            }
        }
        return sum;
    }
}
