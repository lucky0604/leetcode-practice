package com.fastdata.algorithm.medium.stack;

import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * @Date: create in 1/30/21 - 10:40 AM
 */
// TODO: to be understand
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        int result = 0;
        // 先把第一个元素放入栈中
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i ++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                final int pop = stack.pop();
                if (stack.size() == 0) {
                    result += pop * arr[i];
                } else {
                    result += pop * Math.min(arr[i], stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 1) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }
}
