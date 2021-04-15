package com.fastdata.algorithm.medium.sort.insertion_sort;

import java.util.PriorityQueue;

/**
 * @ClassName: CustomSortString
 * @Description: https://leetcode.com/problems/custom-sort-string/
 * @Create by: lucky
 * @Date: 4/15/21 10:50 AM
 */

public class CustomSortString {

    public String customSortString(String S, String T) {
        char[] chars = T.toCharArray();
        int beginIndex = 0;
        for (char c: S.toCharArray()) {
            int index = findIndex(chars, beginIndex, c);
            while (index > -1) {
                swap(chars, index, beginIndex);
                beginIndex ++;
                index = findIndex(chars, index + 1, c);
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static int findIndex(char[] chars, int begin, char target) {
        int res = -1;
        for (int i = begin; i < chars.length; i ++) {
            if (chars[i] == target) {
                res = i;
                break;
            }
        }
        return res;
    }
}
