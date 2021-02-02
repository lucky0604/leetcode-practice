package com.fastdata.algorithm.medium.linked_list;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 2/2/21 - 9:52 AM
 */
public class MergeInBetweenLinkedList {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        int count = 0;

        // create a node that represents before ath node
        ListNode end = null;
        while (curr != null && count != a) {
            end = curr;
            curr = curr.next;
            count ++;
        }

        curr = list1;
        // create a node that represents after the bth node
        ListNode join = null;
        count = 0;
        while (count != b) {
            curr = curr.next;
            count ++;
        }
        join = curr.next;

        end.next = list2;
        curr = list2;
        // traverse list2
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = join;
        return list1;
    }
}
