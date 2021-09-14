package com.fastdata.algorithm.medium.dynamic_programmic;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/14 - 14:52
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 **/

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; i --) {
            for (int j = 0; j < 26; j ++) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String ret = "";
        for (String t: dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); i ++) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > ret.length() || (t.length() == ret.length() && t.compareTo(ret) < 0)) {
                    ret = t;
                }
            }
        }
        return ret;
    }
}
