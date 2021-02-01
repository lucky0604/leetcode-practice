package com.fastdata.algorithm.easy.stack;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-outermost-parentheses/
 * @Date: create in 12/22/20 - 10:47 AM
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        String S = "(()()(())";
        removeOuterParentheses(S);
    }

    public static String removeOuterParentheses(String S) {
        /**
         * 基本思路：
         * 1，遍历字符串，'(' +1
         * 2，')' - 1
         * 期望遍历的第一位是'('
         *
         * 算法实现：
         * 1，定义计数器初始值为0，遍历整个字符串
         * 2，如果字符为'('则计数器加1，否则减1
         * 3，基于计数器和当前字符
         */
        int counter = 0;
        char currentChar = ' ';
        String ret = "";
        for (int i = 0; i < S.length(); i ++) {
            currentChar = S.charAt(i);
            counter = currentChar == '(' ? counter + 1 : counter - 1;
            if (counter == 1 && currentChar == '(' || counter == 0 && currentChar == ')') {
                ret = ret;
            } else {
                ret = ret + currentChar;
            }
        }
        return ret;
    }
}
