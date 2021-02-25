package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/word-pattern/
 * @Date: create in 2/25/21 - 2:32 PM
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        char[] pArr = pattern.toCharArray();
        String[] sArr = s.split(" ");

        if (pArr.length != sArr.length) return false;

        for (int i = 0; i < pArr.length; i ++) {
            char a = pArr[i];
            String string = sArr[i];

            if (map.containsKey(a)) {
                if (!map.get(a).equals(string)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                if (!map.containsValue(string)) {
                    map.put(a, string);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
