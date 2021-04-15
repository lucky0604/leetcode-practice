package com.fastdata.algorithm.solutions.ch02.section02;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @ClassName: Solution_2_2_17_Test
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/15/21 12:23 PM
 */

public class Solution_2_2_17_Test {

    @Test
    public void testCreateList() {
        Solution_2_2_17<Comparable> linkedList = Solution_2_2_17.createList();
        assertEquals(6, linkedList.size());
    }

    @Test
    public void testMergeSort() {

    }
}
