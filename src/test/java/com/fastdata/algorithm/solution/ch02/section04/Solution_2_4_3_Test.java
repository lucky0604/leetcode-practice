package com.fastdata.algorithm.solution.ch02.section04;

import com.fastdata.algorithm.solutions.ch02.section04.Solution_2_4_03_OrderedArray;
import com.fastdata.algorithm.solutions.ch02.section04.Solution_2_4_03_OrderedLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-21 8:28 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_3_Test {

    @Test
    public void testPriorityQueue() {
        Solution_2_4_03_OrderedArray<Integer> priorityQueueOrderedArray = new Solution_2_4_03_OrderedArray<>(5);
        priorityQueueOrderedArray.insert(2);
        priorityQueueOrderedArray.insert(10);
        priorityQueueOrderedArray.insert(4);
        priorityQueueOrderedArray.insert(1);


        assertEquals(String.valueOf(10), String.valueOf(priorityQueueOrderedArray.removeMax()));
        assertEquals(String.valueOf(4), String.valueOf(priorityQueueOrderedArray.removeMax()));
        assertEquals(String.valueOf(2), String.valueOf(priorityQueueOrderedArray.removeMax()));
        assertEquals(String.valueOf(1), String.valueOf(priorityQueueOrderedArray.removeMax()));

    }

    @Test
    public void testPriorityQueueOrderedLinkedList() {
        Solution_2_4_03_OrderedLinkedList<Integer> priorityQueueOrderedLinkedList = new Solution_2_4_03_OrderedLinkedList<>();
        priorityQueueOrderedLinkedList.insert(2);
        priorityQueueOrderedLinkedList.insert(10);
        priorityQueueOrderedLinkedList.insert(4);
        priorityQueueOrderedLinkedList.insert(1);
        assertEquals(String.valueOf(10), String.valueOf(priorityQueueOrderedLinkedList.removeMax()));
        assertEquals(String.valueOf(4), String.valueOf(priorityQueueOrderedLinkedList.removeMax()));
        assertEquals(String.valueOf(2), String.valueOf(priorityQueueOrderedLinkedList.removeMax()));
        assertEquals(String.valueOf(1), String.valueOf(priorityQueueOrderedLinkedList.removeMax()));
    }
}
