package com.fastdata.algorithm.medium.backtracking;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-20 10:43 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/count-sorted-vowel-strings/
 **/

public class CountSortedVowelStrings {

    private int count = 0;

    public int countVowelStrings(int n) {
        backtracking(n, 0);
        return count;
    }

    private void backtracking(int n, int index) {
        if (n == 0) {
            count ++;
            return;
        }
        // cause string length is 5 'a, e, i, o, u'
        for (int i = index; i < 5; i ++) {
            backtracking(n - 1, i);
        }
    }
}
