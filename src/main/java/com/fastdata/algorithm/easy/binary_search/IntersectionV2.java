package com.fastdata.algorithm.easy.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @Date: create in 12/21/20 - 11:51 AM
 */
public class IntersectionV2 {
    public static void main(String[] args) {
        int[] result = intersect(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println("result = " + result);
    }

    /**
     * m = nums1.length; n = nums2.length
     * m <= n
     * merge after sorted: time complexity: O(m+n)
     * spatial complexity: O(m)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 1, sort two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 2, define a result list
        List<Integer> res = new ArrayList();
        // 3, define two index
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                res.add(nums1[idx1]);
                idx1 ++;
                idx2 ++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1 ++;
            } else {
                idx2 ++;
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
