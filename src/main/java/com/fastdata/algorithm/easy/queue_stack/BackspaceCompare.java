package com.fastdata.algorithm.easy.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/backspace-string-compare/
 * @Date: create in 12/25/20 - 11:21 AM
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println("s = " + backspaceChar(s));
        System.out.println("t = " + backspaceChar(t));
    }

    public static boolean backspaceCompare(String S, String T) {
        return backspaceChar(S).equals(backspaceChar(T)) ? true: false;
    }

    private static String backspaceChar(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        String ret = "";
        for (int i = 0; i < s.length(); i ++) {
            if ('#' == s.charAt(i) && !stack.isEmpty()) {
                stack.pop();
            } else if ('#' != s.charAt(i)) {
                stack.push(s.charAt(i));
            }
        }
        for (char item: stack) {
            ret += item;
        }
        return ret;
    }

}
