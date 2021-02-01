package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * @Date: create in 1/28/21 - 10:11 AM
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {

    }

    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            int temp = 0;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] > temp) {
                    temp = arr[j];
                }
            }
            arr[i] = temp;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

}
