package com.fastdata.algorithm.medium.sort;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/rearrange-words-in-a-sentence/
 * @Date: create in 3/23/21 - 10:52 AM
 */
public class RearrangeWordsInASentence {

    class WordsType {
        private int len;
        private int index;
        WordsType(int len, int index) {
            this.len = len;
            this.index = index;
        }
    }

    public String arrangeWords(String text) {
        PriorityQueue<WordsType> pq = new PriorityQueue<WordsType>((a, b) -> {
            if (a.len > b.len) return 1;
            if (a.len < b.len) return -1;
            return a.index - b.index;
        });
        String[] textArr = text.split(" ", 100000000);
        for (int i = 0; i < textArr.length; i ++) {
            pq.add(new WordsType(textArr[i].length(), i));
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            sb.append(textArr[pq.poll().index].toLowerCase()).append(" ");
        }
        return (sb.toString().substring(0, 1).toUpperCase() + sb.toString().substring(1)).trim();
    }
}
