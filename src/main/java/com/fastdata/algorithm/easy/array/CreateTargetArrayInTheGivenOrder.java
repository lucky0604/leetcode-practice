package com.fastdata.algorithm.easy.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/create-target-array-in-the-given-order/
 * @Date: create in 12/29/20 - 11:30 AM
 */
public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,0};
        int[] index = new int[]{0,1,2,3,0};
        int[] res = createTargetArray(nums, index);
        System.out.println("res = " + Arrays.toString(res));
    }

    private static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        ArrayList tempArray = new ArrayList();

        if (nums.length == 1) return nums;
        // 利用ArrayList，添加元素以index中元素为索引，nums中元素为值
        for (int i = 0; i < nums.length; i ++) {
            tempArray.add(index[i], nums[i]);
        }

        for (int j = 0; j < tempArray.size(); j ++) {
            res[j] = (Integer)tempArray.get(j);
        }
        return res;
    }
}
