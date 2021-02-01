package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @Date: create in 1/7/21 - 11:12 AM
 */
public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength = 0;
        int Blength = 0;
        ListNode temp = headA;
        while (temp != null) {
            Alength ++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            Blength ++;
            temp = temp.next;
        }
        if (Alength > Blength) {
            for (int i = 0; i < Alength - Blength; i ++) {
                headA = headA.next;
            }
        } else if (Blength > Alength) {
            for (int i = 0; i < Blength - Alength; i ++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}