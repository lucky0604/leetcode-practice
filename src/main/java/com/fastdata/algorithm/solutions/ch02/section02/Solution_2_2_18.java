package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @ClassName: Solution_2_2_18
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/16/21 11:15 AM
 */

public class Solution_2_2_18<Item> {

    /**
     * implement a LinkedList
     */
    public class Node {
        Item item;
        Solution_2_2_18.Node next;
        Node() {}
        Node(Item item) {
            this.item = item;
        }
    }

    int size;
    Solution_2_2_18.Node head;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Solution_2_2_18.Node newNode = new Solution_2_2_18.Node(item);
        newNode.next = head;
        head = newNode;
        size ++;
    }

    public Iterator<Item> iterator() {
        return new Solution_2_2_18.ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node curr = head;
        public boolean hasNext() {
            return curr != null;
        }

        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    /**
     * initial a linked list
     * @return
     */
    public static Solution_2_2_18<Comparable> createList() {
        Solution_2_2_18<Comparable> linkedList = new Solution_2_2_18<>();
        linkedList.add(0);
        linkedList.add(0);
        linkedList.add(1);
        return linkedList;
    }

    public static Solution_2_2_18.Node shuffle(Solution_2_2_18.Node firstHalf) {
        if (firstHalf == null || firstHalf.next == null) return firstHalf;
        // separate the linked list by mid node
        Solution_2_2_18.Node mid = getMiddle(firstHalf);
        Solution_2_2_18.Node secondHalf = mid.next;
        mid.next = null;
        return shuffleItems(firstHalf, secondHalf);
    }

    private static Solution_2_2_18.Node getMiddle(Solution_2_2_18.Node root) {
        // find the mid node by using fast-slow pointer
        if (root == null) return null;
        Solution_2_2_18.Node slow = root;
        Solution_2_2_18.Node fast = root;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * shuffle two halves items
     * @param firstHalf
     * @param secondHalf
     * @return
     */
    private static Solution_2_2_18.Node shuffleItems(Solution_2_2_18.Node firstHalf, Solution_2_2_18.Node secondHalf) {
        Solution_2_2_18.Node dummyHead = new Solution_2_2_18().new Node();
        Solution_2_2_18.Node curr = dummyHead;

        int[] listSizes = getListSizes(firstHalf, secondHalf);
        int firstHalfLength = listSizes[0];
        int secondHalfLength = listSizes[1];

        while (firstHalf != null && secondHalf != null) {
            double random = StdRandom.uniform();
            // select elements according to the Gilbert-Shannon-Reeds model
            double selectFromFirstHalfProbability = firstHalfLength / (double) (firstHalfLength + secondHalfLength);

            if (random < selectFromFirstHalfProbability) {
                curr.next = firstHalf;
                firstHalf = firstHalf.next;
                firstHalfLength --;
            } else {
                curr.next = secondHalf;
                secondHalf = secondHalf.next;
                secondHalfLength --;
            }
            curr = curr.next;
        }
        curr.next = firstHalf == null ? secondHalf: firstHalf;
        return dummyHead.next;
    }

    /**
     * count two half linked list length
     * @param firstHalf
     * @param secondHalf
     * @return
     */
    private static int[] getListSizes(Solution_2_2_18.Node firstHalf, Solution_2_2_18.Node secondHalf) {
        int firstHalfLength = 0;
        int secondHalfLength = 0;

        while (firstHalf != null && secondHalf != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
            firstHalfLength ++;
            secondHalfLength ++;
        }

        while (firstHalf != null) {
            firstHalfLength ++;
            firstHalf = firstHalf.next;
        }
        while (secondHalf != null) {
            secondHalfLength ++;
            secondHalf = secondHalf.next;
        }
        return new int[]{firstHalfLength, secondHalfLength};
    }
}
