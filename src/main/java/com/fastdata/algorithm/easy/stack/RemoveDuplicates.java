package com.fastdata.algorithm.easy.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @Date: create in 12/22/20 - 12:58 PM
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String S = "abbacda";
        String result = removeDuplicates(S);
        System.out.println("result = " + result);
    }

    public static String removeDuplicates(String S) {
        /**
         * 基本思路：
         * 1，遍历字符串，若栈中不为空并且查询栈顶部元素与当前字符相同，则删除栈顶部元素
         * 2，否则将当前字符继续推入栈中
         * 3，由于栈后进先出，返回时的字符串为反转后的，需要定义一个返回的栈重新组装字符串
         */
        Stack<Character> stack = new Stack<Character>();
        String ret = "";
        Stack<Character> retStack = new Stack<Character>();
        for (int i = 0; i < S.length(); i ++) {
            char item = S.charAt(i);
            if (!stack.empty() && stack.peek().equals(item)) {
                stack.pop();
            } else {
                stack.push(item);
            }
        }
        while (!stack.empty()) {
            char item = stack.pop();
            retStack.push(item);
        }
        while (!retStack.empty()) {
            char item = retStack.pop();
            ret = ret + item;
        }
        return ret;
    }
}
