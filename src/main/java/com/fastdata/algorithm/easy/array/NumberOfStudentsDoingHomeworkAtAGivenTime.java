package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 * @Date: create in 1/27/21 - 10:21 AM
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

    public static void main(String[] args) {
        int[] startTime = new int[]{1,2,3};
        int[] endTime = new int[]{3,2,7};
        int queryTime = 4;
        int ret = busyStudent(startTime, endTime, queryTime);
        System.out.println("ret = " + ret);
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[][] duration = new int[startTime.length][2];
        int count = 0;
        for (int i = 0; i < startTime.length; i ++) {
            duration[i][0] = startTime[i];
            duration[i][1] = endTime[i];
            if (queryTime >=duration[i][0] && queryTime <= duration[i][1]) {
                count ++;
            }
        }
        return count;
    }
}
