package com.fastdata.algorithm.easy.queue_stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/design-a-stack-with-increment-operation/
 * @Date: create in 1/29/21 - 9:53 AM
 */
public class DesignAStackWithIncrementOperation {

    private int arr[];
    private int index;

    public DesignAStackWithIncrementOperation(int maxSize) {
        arr = new int[maxSize];
        index = -1;
    }

    public void push(int x) {
        if (index + 1 < arr.length) {
            arr[index ++] = x;
        }
    }

    public int pop() {
        return index < 0 ? -1 : arr[--index];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, arr.length); i ++) {
            arr[i] += val;
        }
    }
}
