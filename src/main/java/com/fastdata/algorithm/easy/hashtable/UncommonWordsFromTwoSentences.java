package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * @Date: create in 1/18/21 - 11:42 AM
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] aArr = A.split("\\ ");
        String[] bArr = B.split("\\ ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < aArr.length; i ++) {
            map.put(aArr[i], map.getOrDefault(aArr[i], 0) + 1);
        }
        for (int i = 0; i < bArr.length; i ++) {
            map.put(bArr[i], map.getOrDefault(bArr[i], 0) + 1);
        }
        List<String> uniqueArr = new ArrayList<>();
        for (String str: map.keySet()) {
            if (map.get(str) == 1) {
                uniqueArr.add(str);
            }
        }
        System.out.println(map);
        String[] ret = new String[uniqueArr.size()];
        for (int i = 0; i < uniqueArr.size(); i ++) {
            ret[i] = uniqueArr.get(i);
        }
        return ret;
    }
}
