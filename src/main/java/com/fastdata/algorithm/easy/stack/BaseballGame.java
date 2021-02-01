package com.fastdata.algorithm.easy.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/baseball-game/
 * @Date: create in 12/23/20 - 10:09 AM
 */
public class BaseballGame {
    public static void main(String[] args) {
        String[] str = new String[]{"1", "2", "3", "C", "6", "D", "+"};
        calPoints(str);
    }

    public static int calPoints(String[] ops) {
        /**
         * 基本思路：
         * 利用栈的特性
         * 遍历字符串数组
         */
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String i :ops) {
            // 若遍历的元素为C，则从栈顶端删除一个元素
            if ("C".equals(i)) {
                stack.pop();
            } else if ("D".equals(i)) {
                // 若遍历的元素为D，则将栈顶端的元素 * 2并将结果推入栈中
                int newItem = stack.peek();
                stack.push(newItem * 2);
            } else if ("+".equals(i)) {
                // 若遍历的元素为+，则将栈顶端元素和上一个元素相加，并将结果重新推入栈中
                int last = stack.pop();
                int newtop = last + stack.peek();
                stack.push(last);
                stack.push(newtop);
            } else {
                // 若不符合上述三个条件，则将遍历的元素直接推入栈中
                stack.push(Integer.parseInt(i));
            }
        }
        for (int item : stack) {
            result += item;
        }
        System.out.println("stack = " + stack);
        return result;
    }
}
