package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * @Date: create in 1/18/21 - 11:42 AM
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] aArr = A.split("\\ ");
        String[] bArr = B.split("\\ ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < aArr.length; i ++) {
            map.put(aArr[i], i);
        }
        List<String> ret = new ArrayList<>();
        for (String item: bArr) {
            if (!map.containsKey(item)) {
                ret.add(item);
            }
        }
        String[] res = new String[ret.size()];
        for (int i = 0; i < ret.size(); i ++) {
            res[i] = ret.get(i);
        }
        return res;
    }
}
