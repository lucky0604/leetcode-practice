package com.fastdata.algorithm.solutions.ch02.section02;

import java.util.Iterator;

/**
 * @ClassName: Solution_2_2_17
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/15/21 11:23 AM
 */
public class Solution_2_2_17<Item> {

    private class Node {
        Item item;
        Node next;
        Node() {}
        Node(Item item) {
            this.item = item;
        }
    }

    private int size;
    private Node head;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size ++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
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

    public static Solution_2_2_17<Comparable> createList() {
        Solution_2_2_17<Comparable> linkedList = new Solution_2_2_17<>();
        linkedList.add(2);
        linkedList.add(-1);
        linkedList.add(22);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(19);
        return linkedList;
    }

    private static Solution_2_2_17.Node mergeSort(Solution_2_2_17<Comparable>.Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        Solution_2_2_17<Comparable>.Node low = root;
        Solution_2_2_17<Comparable>.Node mid = root;
        Solution_2_2_17<Comparable>.Node high = root;
        Solution_2_2_17<Comparable>.Node curr = root;

        boolean secondSubArray = false;

        while (curr != null && curr.next != null) {
            if (curr.item.compareTo(curr.next.item) > 0) {
                if (!secondSubArray) {
                    mid = curr;
                    secondSubArray = true;
                } else {
                    high = curr;
                    low = merge(low, mid, high);
                    mid = high;
                }
            }
            curr = curr.next;
        }

        if (high.next != null && curr != null) {
            low = merge(low, mid, curr);
        }
        return low;
    }

    private static Solution_2_2_17<Comparable>.Node merge(Solution_2_2_17<Comparable>.Node low, Solution_2_2_17<Comparable>.Node mid, Solution_2_2_17<Comparable>.Node high) {
        Solution_2_2_17<Comparable>.Node leftNode = low;
        Solution_2_2_17<Comparable>.Node rightNode = mid.next;
        Solution_2_2_17<Comparable>.Node newLow;
        Solution_2_2_17<Comparable>.Node afterLastNode = high.next;
        Solution_2_2_17<Comparable>.Node aux;

        if (leftNode.item.compareTo(rightNode.item) <= 0) {
            newLow = leftNode;
            aux = leftNode;
            leftNode = leftNode.next;
        } else {
            newLow = rightNode;
            aux = rightNode;
            rightNode = rightNode.next;
        }

        while (leftNode != mid.next && rightNode != high.next) {
            if (leftNode.item.compareTo(rightNode.item) <= 0) {
                aux.next = leftNode;
                aux = leftNode;
                leftNode = leftNode.next;
            } else {
                aux.next = rightNode;
                aux = rightNode;
                rightNode = rightNode.next;
            }
        }

        if (leftNode == mid.next) {
            aux.next = rightNode;
        } else {
            aux.next = leftNode;
            mid.next = afterLastNode;
        }
        return newLow;
    }
}
