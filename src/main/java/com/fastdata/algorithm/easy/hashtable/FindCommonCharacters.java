package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-common-characters/
 * @Date: create in 1/16/21 - 1:02 PM
 */
// TODO: to be understand
public class FindCommonCharacters {
    public static List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        if (A == null || A.length == 0) return ret;
        HashMap<Character, Integer> union = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) union.put(A[0].charAt(i), union.getOrDefault(A[0].charAt(i), 0) + 1);
        for (int i = 0; i < A.length; i ++) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j ++) {
                char curr = A[i].charAt(j);
                if (union.containsKey(curr)) temp.put(curr, Math.min(union.get(curr), temp.getOrDefault(curr, 0) + 1));
            }
            union = temp;
        }
        for (char c: union.keySet()) {
            for (int i = 0; i < union.get(c); i ++) ret.add(c + "");
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"bella","label","roller"};
        commonChars(A);

    }
}
