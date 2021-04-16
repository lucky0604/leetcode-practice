package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @ClassName: Solution_2_2_18_Test
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/16/21 12:01 PM
 */

public class Solution_2_2_18_Test {

    @Test
    public void testShuffleLinkedList() {
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < 100000; i ++) {
            Solution_2_2_18<Comparable> list = Solution_2_2_18.createList();
            Solution_2_2_18<Comparable>.Node newHead = Solution_2_2_18.shuffle(list.head);
            StringJoiner shuffledList = new StringJoiner(" ");
            while (newHead != null) {
                shuffledList.add(String.valueOf(newHead.item));
                newHead = newHead.next;
            }
            String value = shuffledList.toString();
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        StdOut.println("List: 0 0 1");
        for (Map.Entry<String, Integer> entry: countMap.entrySet()) {
            StdOut.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
