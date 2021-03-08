package com.fastdata.algorithm.medium.heap;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-the-most-competitive-subsequence/
 * @Date: create in 3/8/21 - 10:18 AM
 */
// TODO: to be understand
public class FindTheMostCompetitiveSubsequence {

    /**
     * 1, one naive approach comes to mind is to maintain a collection of size k and start arranging element in increasing order in that collection.
     * 2, for that stack is usefull as we can compare top element (last element) directly in o(1) time.
     * 3, so, iterate through the nums array and push element into stack if current element is greater then stack.peek. else if current element is smaller then peek element of stack remove elements from stack till again stack comes in a increasing order to be able to add current item.
     * 4, But we need to handle a condition that stack size should be of size k exactly. so in step 3 pop elements from stack if there are still some possiblity left to complete size k along with element peek value check. ie. (stack.size()+ nums.length-i > k) elements_left_in_loop + stack.size. similarly add element to stack only if current stack size <k.
     * 5, once loop finishes just start filling output array from k-1 to 0 from stack.pop()
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive(int[] nums, int k) {
        int[] op = new int[k];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            // key point
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i --) {
            op[i] = nums[stack.pop()];
        }
        return op;
    }
}
