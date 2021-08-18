package com.fastdata.algorithm.easy.queue_stack;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * @Date: create in 1/29/21 - 10:19 AM
 */
public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        String S = "()))((";
        int ret = minAddToMakeValid(S);
        System.out.println("ret = {}" + ret);
    }

    public static int minAddToMakeValid(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < S.length(); i ++) {
            if (S.charAt(i) == '(') {
                stack.add(S.charAt(i));
            }
            if (S.charAt(i) == ')' && stack.isEmpty()) {
                count ++;
                continue;
            }
            if (S.charAt(i) == ')') {
                stack.pop();
            }
        }
        return stack.size() + count;
    }
}
