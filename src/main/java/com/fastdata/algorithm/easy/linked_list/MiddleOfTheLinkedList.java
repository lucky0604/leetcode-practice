package com.fastdata.algorithm.easy.linked_list;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/middle-of-the-linked-list/
 * @Date: create in 1/5/21 - 12:59 PM
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int a = 5;
        int mid = a / 2;
        System.out.println("mid = " + mid);
    }

    private static ListNode middleNode(ListNode head) {
        // find length of linkedList with a pointer beginning with the head
        int length = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            length += 1;
            pointer = pointer.next;
        }

        // find mid-point of length, and re-point the pointer back to the head of the linkedList
        length /= 2;
        pointer = head;

        // find the mid-point of the linkedList and return a reference to it
        while (length > 0) {
            pointer = pointer.next;
            length --;
        }
        return pointer;
    }
}

