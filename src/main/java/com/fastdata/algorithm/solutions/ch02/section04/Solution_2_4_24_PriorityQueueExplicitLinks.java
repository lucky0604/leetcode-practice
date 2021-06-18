package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-03 1:52 PM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_24_PriorityQueueExplicitLinks<Key extends Comparable> {

    private class PQNode {
        PQNode parent;
        PQNode leftChild;
        PQNode rightChild;

        Key value;
    }

    private PQNode priorityQueue;
    private int size = 0;    // the first node will not be used to simplify index computation

    Solution_2_4_24_PriorityQueueExplicitLinks() {
        priorityQueue = new PQNode();    // 0 position is not used
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(lg N)
    public void insert(Key key) {
        size ++;

        PQNode newNode = new PQNode();
        newNode.value = key;

        int parentIndex = size / 2;    // the index of the parent of the new node
        int[] pathToParentNode = generatePathToNode(parentIndex);
        PQNode parentNode = getNode(pathToParentNode);

        if (parentNode.leftChild == null) {
            parentNode.leftChild = newNode;
        } else {
            parentNode.rightChild = newNode;
        }
        newNode.parent = parentNode;
        swim(newNode);
    }

    // O(lg N)
    public Key deleteMax() {
        if (size == 0) {
            throw new RuntimeException("Priority Queue underflow");
        }

        Key max = priorityQueue.leftChild.value;
        int parentNodeIndex = size / 2;    // the index of the parent of the last node

        // if it is deleting the root
        if (parentNodeIndex == 0) {
            priorityQueue.leftChild = null;
            return max;
        }

        int[] pathToLastNodeParent = generatePathToNode(parentNodeIndex);
        PQNode lastNodeParent = getNode(pathToLastNodeParent);

        Key lastItemValue;

        if (lastNodeParent.rightChild != null) {
            lastItemValue = lastNodeParent.rightChild.value;
            lastNodeParent.rightChild.parent = null;
            lastNodeParent.rightChild = null;
        } else {
            lastItemValue = lastNodeParent.leftChild.value;
            lastNodeParent.leftChild.parent = null;
            lastNodeParent.leftChild = null;
        }

        priorityQueue.leftChild.value = lastItemValue;
        sink(priorityQueue.leftChild);

        size --;
        return max;
    }

    // O(lg N)
    private void swim(PQNode node) {
        while (node.parent.value != null && ArrayUtil.less(node.parent.value, node.value)) {
            // swap node values
            Key tmp = node.value;
            node.value = node.parent.value;
            node.parent.value = tmp;

            node = node.parent;
        }
    }

    // O(lg N)
    private void sink(PQNode node) {
        boolean isTheLeftChildTheHighestItem;
        Key highestItemValue;

        // repeat while the current node exists and has at least 1 child
        while (node != null && node.leftChild != null) {

            // check which child is bigger
            if (node.rightChild != null) {
                if (ArrayUtil.less(node.leftChild.value, node.rightChild.value)) {
                    isTheLeftChildTheHighestItem = false;
                    highestItemValue = node.rightChild.value;
                } else {
                    isTheLeftChildTheHighestItem = true;
                    highestItemValue = node.leftChild.value;
                }
            } else {
                isTheLeftChildTheHighestItem = true;
                highestItemValue = node.leftChild.value;
            }

            // compare highest value child and parent
            if (ArrayUtil.less(node.value, highestItemValue)) {
                Key tmp = node.value;

                if (isTheLeftChildTheHighestItem) {
                    node.value = node.leftChild.value;
                    node.leftChild.value = tmp;
                    node = node.leftChild;
                } else {
                    node.value = node.rightChild.value;
                    node.rightChild.value = tmp;
                    node = node.rightChild;
                }
            } else {
                break;
            }
        }
    }

    // O(lg N)
    private int[] generatePathToNode(int nodeIndex) {
        int pathSize = (int) (Math.ceil(Math.log10(nodeIndex) / Math.log10(2)) + 1);
        if (pathSize <= 0) {
            return new int[0];
        }
        int[] pathToNode = new int[pathSize];
        for (int i = pathSize - 1; i >= 0; i --) {
            pathToNode[i] = nodeIndex;

            nodeIndex /= 2;
        }
        return pathToNode;
    }

    // O(lg N)
    private PQNode getNode(int[] pathToNode) {
        int currentIndex = 1;
        PQNode currentNode = priorityQueue.leftChild;

        for (int i = 0; i < pathToNode.length && currentNode!= null; i ++) {
            if (pathToNode[i] == currentIndex * 2) {
                currentNode = currentNode.leftChild;
                currentIndex = currentIndex * 2;
            } else if (pathToNode[i] == currentIndex * 2 + 1) {
                currentNode = currentNode.rightChild;
                currentIndex = currentIndex * 2 + 1;
            }
        }
        if (currentNode == null) {
            return priorityQueue;
        }
        return currentNode;
    }
}
