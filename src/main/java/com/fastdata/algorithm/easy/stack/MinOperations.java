package com.fastdata.algorithm.easy.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/crawler-log-folder/
 * @Date: create in 12/24/20 - 10:55 AM
 */
public class MinOperations {
    public static void main(String[] args) {
        String[] logs = new String[]{"./","../","./"};
        minOperations(logs);
    }

    public static int minOperations(String[] logs) {
        /**
         * 基本思路：
         * 利用栈的特性，遍历列表
         * 1，"../"操作符时，从当前栈去除顶部元素
         * 2，"./"操作符时，不做操作
         * 3，其他操作符时，直接推入栈
         * 时间复杂度为O(n)
         */
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < logs.length; i ++) {
            if ("../".equals(logs[i]) && !stack.isEmpty()) {
                stack.pop();
            } else if ("./".equals(logs[i])) {
                stack.peek();
            } else {
                stack.push(logs[i]);
            }
        }
        int count = 0;
        for (String item: stack) {
            if (!item.equals("../") || !item.equals("./")) {
                count ++;
            }
        }
        System.out.println("stack = " + stack);
        return count;
    }
}
