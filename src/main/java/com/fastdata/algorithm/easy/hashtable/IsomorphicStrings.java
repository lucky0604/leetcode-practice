package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		// set hashmap to assign keys and values to the string
		Map<Character, Character> map = new HashMap<Character, Character>();
		
		char[] sArr = new char[s.length()];
		char[] tArr = new char[t.length()];
		
		for (int i = 0; i < s.length(); i ++) {
			sArr[i] = s.charAt(i);
			tArr[i] = t.charAt(i);
		}
		for (int i = 0; i < sArr.length; i ++) {
			char s1 = sArr[i];
			char t1 = tArr[i];
			if (!map.containsKey(s1) && !map.containsValue(t1)) {
				map.put(s1, t1);
			}
			if ((!map.containsKey(s1) && map.containsValue(t1) || !map.get(s1).equals(t1))) {
				return false;
			}
		}
		return true;
	}
}
