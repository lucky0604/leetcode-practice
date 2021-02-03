package com.fastdata.algorithm.medium.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/linked-list-components/
 * @Date: create in 2/3/21 - 12:50 PM
 */
public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {

        /**
         * 1. First Move all  element of G  into a another datastruture which can be used to detect the presence of element of G.
         * 2. This can be achieved by using creating a HashSet or by creating the array of size the max element. then putting the element in its proper position.
         * 3. Then simply traverse the LinkedList and check the element present in HashSet.
         * 4. If It is present in the HashSet, the simply **set = 1**. if it is not present then check set = 1 , and increment the count.
         */

        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int count = 0;
        // 判断是否存在于set中
        int flag = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                flag = 1;
            } else if (flag == 1) {
                count ++;
                flag = 0;
            }
            head = head.next;
        }
        return flag == 1 ? count + 1: count;
    }
}
