package com.fastdata.algorithm.solutions.ch02.section03;

import java.util.StringJoiner;

import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Lucky
 * @Date: 2021-04-29 22:47:30    
 * @Version: 1.0
 * @Description: 
 */

public class Solution_2_3_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrayLength = 16;
		Comparable[] array = ArrayGenerator.generateRandomArrayWith2Values(arrayLength);
		
		StringJoiner originalArray = new StringJoiner(" ");
		for (Comparable element: array) {
			originalArray.add(String.valueOf(element));
		}
		StdOut.println("Original array: " + originalArray);
		sort3WayPartition(array);
		StringJoiner sortedArray = new StringJoiner(" ");
		for (Comparable element: array) {
			sortedArray.add(String.valueOf(element));
		}
		StdOut.println("Sorted array: " + sortedArray);
	}
	
	private static void sort3WayPartition(Comparable[] array) {
		
		int lt = 0;
		int gt = array.length - 1;
		int i = lt + 1;
		
		Comparable pivot = array[0];
		
		while (i <= gt) {
			int comparison = array[i].compareTo(pivot);
			
			if (comparison < 0) {
				ArrayUtil.exchange(array, lt, i);
				lt ++;
				i ++;
			} else if (comparison > 0) {
				ArrayUtil.exchange(array, i, gt);
				gt --;
			} else {
				i ++;
			}
		}
	}

}
