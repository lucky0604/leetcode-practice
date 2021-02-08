package com.fastdata.algorithm.medium.linked_list;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/split-linked-list-in-parts/
 * @Date: create in 2/8/21 - 10:14 AM
 */
// TODO: to be understand
public class SplitLinkedListInParts {
    public ListNode[] splitListParts(ListNode root, int k) {
        ListNode[] ret = new ListNode[k];
        if (root == null) return ret;

        int length = 0;
        ListNode curr = root;
        while (curr != null) {
            length ++;
            curr = curr.next;
        }

        // the length of each bucket in k buckets
        int eachLength = length / k;
        // not every time we get equal size for all the buckets so sometimes of the bucket will have extra elements in it
        // so we have to find the length of extra buckets by mod operation
        int extraLength = length % k;

        int index = 0;
        curr = root;
        // loop for all the elements in the list
        while (curr != null) {
            // for every bucket we start with the current element
            ListNode head = curr;
            // each part difference is either 0 or 1, we use the reminder to identify the difference
            int difference = extraLength <= 0 ? 0 : 1;
            // move the pointer to the size of each length
            for (int i = 0; i < eachLength + difference - 1; i ++) {
                curr = curr.next;
            }

            // set the next to null
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;

            // add to the result array
            ret[index ++] = head;
            // decrement the extra length
            extraLength --;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(5 % 3);
    }
}
