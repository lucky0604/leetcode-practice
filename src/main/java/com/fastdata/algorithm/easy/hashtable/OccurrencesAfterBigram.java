package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/occurrences-after-bigram/
 * @Date: create in 1/18/21 - 12:20 PM
 */
public class OccurrencesAfterBigram {
    public String[] findOccurrences(String text, String first, String second) {
        String[] textArr = text.split("\\ ");
//        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < textArr.length - 2; i ++) {
            if (textArr[i].equals(first) && textArr[i + 1].equals(second)) {
                res.add(textArr[i + 2]);
            }
        }
        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i ++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
