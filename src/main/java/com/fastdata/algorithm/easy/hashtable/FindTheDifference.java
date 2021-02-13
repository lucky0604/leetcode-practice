package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-the-difference/
 * @Date: created in 2021/2/13 - 13:08
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i ++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character c: tMap.keySet()) {
            if (!sMap.containsKey(c)) return c;
            if ((tMap.get(c) - sMap.get(c)) != 0) {
                return c;
            }
        }
        return 'a';
    }
}
