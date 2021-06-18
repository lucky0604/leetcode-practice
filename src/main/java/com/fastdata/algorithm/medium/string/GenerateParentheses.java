package com.fastdata.algorithm.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/8/21 11:24 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/generate-parentheses/
 **/
// TODO: to be understand
public class GenerateParentheses {

    /**
     * backtracking algorithm
     * @param n
     * @return
     */
    public List<String> generateParentheses(int n) {

        List<String> ret = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        backtracking(ret, tmp, n, 0, 0);
        return ret;
    }

    private void backtracking(List<String> ret, StringBuilder tmp, int n, int left, int right) {
        // condition
        // if string length bigger or equals the double n, tmp string is valid, add it into list
        if (tmp.length() >= 2 * n) {
            ret.add(tmp.toString());
            return;
        }
        if (left < n) {
            tmp.append("(");
            backtracking(ret, tmp, n, left + 1, right);
            tmp.setLength(tmp.length() - 1);
        }
        if (right < left) {
            tmp.append(")");
            backtracking(ret, tmp, n, left, right + 1);
            tmp.setLength(tmp.length() - 1);
        }
    }
}
