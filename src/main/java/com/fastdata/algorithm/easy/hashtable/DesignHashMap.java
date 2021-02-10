package com.fastdata.algorithm.easy.hashtable;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/design-hashmap/
 * @Date: created in 2021/2/10 - 21:13
 */
public class DesignHashMap {

    Node[] nodes;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        nodes = new Node[2096];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node node = nodes[key % 2096];
        if (node == null) {
            nodes[key % 2096] = new Node(key, value);
        } else {
            while (node.getNext() != null && node.getKey() != key) {
                node = node.getNext();
            }
            if (node.getKey() == key) {
                node.setVal(value);
            } else {
                node.setNext(new Node(key, value));
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node node = nodes[key % 2096];
        while (node != null && node.getKey() != key) {
            node = node.getNext();
        }
        return node == null ? -1 : node.getVal();
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node node = nodes[key % 2096];
        if (node != null) {
            if (node.getKey() == key) {
                nodes[key % 2096] = node.getNext();
            } else {
                while (node.getNext() != null && node.getNext().getKey() != key) {
                    node = node.getNext();
                }
                if (node.getNext() != null) {
                    node.setNext(node.getNext().getNext());
                }
            }
        }
    }
}

class Node {
    int val;
    int key;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public int getVal() {
        return val;
    }
    public int getKey() {
        return key;
    }
    public Node getNext() {
        return next;
    }
}
