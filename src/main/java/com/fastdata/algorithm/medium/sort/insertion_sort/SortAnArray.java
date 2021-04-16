package com.fastdata.algorithm.medium.sort.insertion_sort;

/**
 * @ClassName: SortAnArray
 * @Description: https://leetcode.com/problems/sort-an-array/
 * @Create by: lucky
 * @Date: 4/16/21 10:19 AM
 */

public class SortAnArray {

    /**
     * because of the time limit, use merge sort
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, aux, low, mid);
        mergeSort(nums, aux, mid + 1, high);
        merge(nums, aux, low, mid, high);
    }

    private static void merge(int[] nums, int[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            aux[i] = nums[i];
        }

        int leftIndex = low;
        int rightIndex = mid + 1;
        int arrIndex = low;
        while (leftIndex <= mid && rightIndex <= high) {
            if (aux[leftIndex] <= aux[rightIndex]) {
                nums[arrIndex] = aux[leftIndex];
                leftIndex ++;
            } else {
                nums[arrIndex] = aux[rightIndex];
                rightIndex ++;
            }
            arrIndex++;
        }
        while (leftIndex <= mid) {
            nums[arrIndex] = aux[leftIndex];
            arrIndex ++;
            leftIndex ++;
        }
    }
}
