package com.fastdata.algorithm.medium.sort;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 * @Date: create in 3/29/21 - 10:17 AM
 */
// TODO: to be understand
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        Iterator<String> it = dictionary.iterator();
        while (it.hasNext()) {
            String word = (String) it.next();
            int length = word.length();
            int i = 0;
            int j = 0;
            while (i < length && j < s.length()) {
                if (word.charAt(i) == s.charAt(j)) i ++;
                j ++;
            }
            if (i == length) {
                // if the word length is greater than the previous computer results
                // if both words are same and
                // if the dictionary word is lexically smaller than the result
                if (length > result.length() || result.length() == length && word.compareTo(result) < 1) {
                    result = word;
                }
            }
        }
        return result;
    }
}
