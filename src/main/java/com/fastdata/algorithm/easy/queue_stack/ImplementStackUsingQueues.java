package com.fastdata.algorithm.easy.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/implement-stack-using-queues/
 * @Date: create in 12/25/20 - 11:51 AM
 */
public class ImplementStackUsingQueues {
}

class MyStack {
    /**
     * 基本思路：
     * 定义两个队列，push元素时通过两个队列调整目标队列的顺序达到和栈结构相同
     */
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (queue1.size() != 0) {
            int temp = queue1.remove();
            queue2.add(temp);
        }
        queue1.add(x);
        while (queue2.size() != 0) {
            int temp = queue2.remove();
            queue1.add(temp);
        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() ? true: false;
    }
}
