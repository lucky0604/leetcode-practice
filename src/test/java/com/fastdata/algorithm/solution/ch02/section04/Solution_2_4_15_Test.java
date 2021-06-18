package com.fastdata.algorithm.solution.ch02.section04;

import com.fastdata.algorithm.solutions.ch02.section04.Solution2_4_15;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-31 9:59 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_15_Test {
    @Test
    public void test() {
        Comparable[] minOrientedHeap = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        assertTrue(Solution2_4_15.certification(minOrientedHeap));

        Comparable[] notMinOrientedHeap = {0, 0, 1, 2, -1, -5, 99, 6, 7, 8};
        assertFalse(Solution2_4_15.certification(notMinOrientedHeap));
    }
}
