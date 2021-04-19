package com.fastdata.algorithm.solutions.ch02.section02;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author lucky
 * @Description
 * @Filename null.java
 * @create 2021-04-19 下午12:37
 */

public class Solution_2_2_20_Test {

    private static boolean validate(int[] expectedIndexSortedArray, int[] indexSortedArray) {
        if (expectedIndexSortedArray.length != indexSortedArray.length) return false;
        for (int i = 0; i < expectedIndexSortedArray.length; i ++) {
            if (expectedIndexSortedArray[i] != indexSortedArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIndexSort() {
        Comparable[] array1 = Solution_2_2_20.generateArray1();
        int[] indexSortArray1 = Solution_2_2_20.indexSort(array1);

        int[] expectedIndexSortedArray1 = {5, 4, 6, 3, 7, 2, 8, 1, 9, 0};
        assertEquals(true, validate(expectedIndexSortedArray1, indexSortArray1));

        Comparable[] array2 = Solution_2_2_20.generateArray2();
        int[] indexSortArray2 = Solution_2_2_20.indexSort(array2);
        int[] expectedIndexSortedArray2 = {3, 2, 1, 0};
        assertEquals(true, validate(expectedIndexSortedArray2, indexSortArray2));
    }
}
