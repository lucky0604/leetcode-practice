package com.fastdata.algorithm.medium.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @Date: create in 2/1/21 - 9:45 AM
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        String s = "(abcd)";
        String ret = reverseParentheses(s);
        System.out.println("ret = " + ret);
    }

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ')') {
                // because it's all lower case characters
                sb = sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
