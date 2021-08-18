package com.fastdata.algorithm.easy.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/min-stack/
 * @Date: create in 12/25/20 - 12:14 PM
 */
public class MinStack {
    /**
     * 基本思路：
     * 定义一个当前最小数变量，与插入的元素进行对比，根据大小改变当前最小数值
     */
    Deque<Integer> stack;
    int currMin;
    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            currMin = x;
        }
        stack.push(currMin);
        if (currMin > x) {
            currMin = x;
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        currMin = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return currMin;
    }
}
