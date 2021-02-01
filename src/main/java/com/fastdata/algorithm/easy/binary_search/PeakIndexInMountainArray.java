package com.fastdata.algorithm.easy.binary_search;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * @Date: create in 12/16/20 - 2:23 PM
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0,2,10,15,2,1, 1,0};
        int result = peakIndexInMountainArray(arr);
        System.out.println("result  = " + result);
        System.out.println("binary value = " + Integer.toBinaryString(9));
    }

    /**
     * 定义两个变量left、right，
     * 一个从0开始，一个从数组最后一位开始，每次取两者中间值，得到该中间位置的元素，
     * 然后和它的前一个元素比较大小，如果小于，说明还没有到山顶，需要继续向前，将中间值加1后赋值给left，
     * 反之就将中间值赋值给right。循环结束的条件是left不小于right，最后返回left即可。
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
