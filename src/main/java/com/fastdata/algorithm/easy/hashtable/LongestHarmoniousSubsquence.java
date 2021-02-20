package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsquence {
	
	/**
	 * 1，Create a Map for frequency of the element occured in array
		2，Interate through loop and update the frequency
		3，Check how many elements less than 1 of the current number (low) has occured till now and how many elements more that 1 of the current element (high) occured, also check the frequency of current element
		4，If both high and low are 0 then we can't create the subsequence with current element
		5，Max possible susequence with current of the is max of low or high + sum of current frequency .
		6，result is max of result till now or the value we got with current at step 5
	 * @param nums
	 * @return
	 */
	
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int ret = 0;
		for (int i = 0; i < nums.length; i ++) {
			int curr = nums[i];
			map.put(curr, map.getOrDefault(curr, 0) + 1);
			
			int high = map.getOrDefault(curr + 1, 0);
			int low = map.getOrDefault(curr - 1, 0);
			int currFreq = map.get(curr);
			if (high == 0 && low == 0)
				currFreq = 0;
			max = Integer.max(low, high);
			ret = Integer.max(ret, max + currFreq);
		}
		
		return ret;
		
	}
}
