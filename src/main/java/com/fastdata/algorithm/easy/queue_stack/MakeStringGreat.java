package com.fastdata.algorithm.easy.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/make-the-string-great/
 * @Date: create in 12/24/20 - 11:25 AM
 */
public class MakeStringGreat {
    public static void main(String[] args) {
        String s = "leEeetcode";
        String result = makeGood(s);
        System.out.println("result = " + result);
    }

    public static String makeGood(String s) {
        if (s.length() == 1) return s;

        Deque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        int index = 0;
        while (index < ch.length) {
            // 若栈为空，则将该元素推入栈中
            if (stack.isEmpty()) {
                stack.push(ch[index]);
                index ++;
                continue;
            }

            // 判断是否互为大小写
            char c = stack.pop();
            if (ch[index] + 32 == c || ch[index] - 32 == c) {
                // 不操作
                index ++;
                continue;
            }
            // 不是互为大小写，把字符串都压入栈中
            stack.push(c);
            stack.push(ch[index]);
            index ++;
        }
        if (stack.isEmpty()) return "";

        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
