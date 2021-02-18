package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		List<String> res = new ArrayList<>();
		int minIndexSum = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i ++) {
			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i ++) {
			if (map.containsKey(list2[i])) {
				int sum = map.get(list2[i]) + i;
				if (sum < minIndexSum) {
					minIndexSum = sum;
					res.clear();
					res.add(list2[i]);
				} else if (minIndexSum == sum) {
					res.add(list2[i]);
				}
			}
		}
		
		String[] ans = res.toArray(new String[res.size()]);
		return ans;
	}

}
