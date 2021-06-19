package com.fastdata.algorithm.medium.backtracking;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/19/21 12:26 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/letter-tile-possibilities/
 **/

public class LetterTilePossibilities {

    private int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length]);
        // remove the empty one
        return count - 1;
    }

    private void backtracking(char[] chars, boolean[] used) {
        count ++;
        for (int i = 0; i < chars.length; i ++) {
            if (used[i] || i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            backtracking(chars, used);
            used[i] = false;
        }
    }
}
