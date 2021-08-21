package com.fastdata.algorithm.medium.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/21/21 12:14 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 **/

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i ++) {
            String token = tokens[i];
            if (isNumer(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumer(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
