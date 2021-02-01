package com.fastdata.algorithm.easy.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/valid-parentheses/
 * @Date: create in 12/25/20 - 12:52 PM
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "({[)";
        boolean ret = isValid(s);
        System.out.println("ret = " + ret);
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++) {
            if (stack.size() > 0) {
                if ((s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ')'
                        && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }

        }
        return stack.isEmpty() ? true: false;
    }
}
