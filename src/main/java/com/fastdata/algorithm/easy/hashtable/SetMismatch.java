package com.fastdata.algorithm.easy.hashtable;

import java.util.HashSet;

public class SetMismatch {
	/**
        Approach: Maintain a HashSet of nums. Go through all the nums. If any duplicate detected through HashSet,
                  we got the duplicate number we were looking for.
                  Also, calculate the sum of all the numbers 1 through n by formula n*(n+1)/2. Then every time we detect a 
                  non-duplicate num, subtract that num from the sum. Finally, sum will be the lost item.
        
        Complexity analysis: Time: O(n). Space: O(n)
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		int duplicateNum = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int num: nums) {
			if (set.contains(num)) {
				duplicateNum = num;
			} else {
				set.add(num);
				sum -= num;
			}
		}
		return new int[] {duplicateNum, sum};
	}
}
