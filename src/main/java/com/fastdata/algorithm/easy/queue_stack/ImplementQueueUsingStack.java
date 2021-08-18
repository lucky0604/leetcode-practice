package com.fastdata.algorithm.easy.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/implement-queue-using-stacks
 * @Date: create in 12/25/20 - 10:58 AM
 */
public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
    }
}

class MyQueue {
    /**
     * 基本思路：
     * 使用两个栈结构，按照队列顺序在pop和peek操作时转换元素顺序
     */
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int peek() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int val = stack1.peek();
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int val = stack1.pop();
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return val;
    }

    public boolean empty() {
        return stack1.isEmpty() ? true : false;
    }
}