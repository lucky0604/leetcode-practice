package com.fastdata.algorithm.solutions.ch02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: Certification
 * Write a check() method that calls sort() for a given array and
 * returns true if sort() puts the array in order and leaves the same set of objects in the
 * array as were there initially, false otherwise. Do not assume that sort() is restricted to
 * move data only with exch(). You may use Arrays.sort() and assume that it is correct.
 * @Date: create in 3/29/21 - 12:43 PM
 */
public class Solution_2_1_16 {

    private static boolean check(Comparable[] arr) {
        // insert all values into the map
        Map<Comparable, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // sort the array
        Arrays.sort(arr);

        // check if the array is sorted
        for (int i = 0; i < arr.length - 1; i ++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }

        // check if the initial set of objects is still in the array
        for (Comparable val : arr) {
            // check if the key in arr
            if (map.containsKey(val)) {
                // get the key's count
                int count = map.get(val);
                // decrement the count
                count --;
                if (count == 0) {
                    map.remove(val);
                } else {
                    map.put(val, count);
                }
            } else {
                return false;
            }
        }
        if (map.size() > 0) {
            return false;
        }
        return true;
    }
}
