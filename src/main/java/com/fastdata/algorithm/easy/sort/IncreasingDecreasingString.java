package com.fastdata.algorithm.easy.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/increasing-decreasing-string/
 * @Date: create in 12/31/20 - 12:29 PM
 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {

    }

    private static String sortString(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a'] ++;
        }
        while (sb.length() < s.length()) {
            helper(sb, freq, true);     // from start to end;
            helper(sb, freq, false);    // from end to start
        }
        return sb.toString();
    }

    private static void helper(StringBuilder sb, int[] freq, boolean d) {
        for (int i = 0; i < 26; i ++) {
            int j = d ? i : 25 - i;
            if (freq[j]-- > 0) {
                sb.append((char) (j + 'a'));
            }
        }
    }
}
