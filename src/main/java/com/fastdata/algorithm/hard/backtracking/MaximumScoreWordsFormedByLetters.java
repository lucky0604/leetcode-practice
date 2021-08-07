package com.fastdata.algorithm.hard.backtracking;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/7/21 10:56 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 **/

public class MaximumScoreWordsFormedByLetters {

    public int maxScoreWords(String[] words, char[] letters, int[] score, int index) {
        int[] frequencyCharacters = new int[score.length];
        for (char ch: letters) {
            frequencyCharacters[ch - 'a'] ++;
        }
        return findMaxScore(words, frequencyCharacters, score, 0);
    }

    private int findMaxScore(String[] words, int[] frequencyCharacters, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        // word not included
        int wordNotIncluded = findMaxScore(words, frequencyCharacters, score, index + 1);

        // word included
        int wordScore = 0;
        boolean flag = true;    // word should be included ? - true
        String word = words[index];
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);

            if (frequencyCharacters[ch - 'a'] == 0) {
                flag = false;    // word should be included? - false
            }

            frequencyCharacters[ch - 'a'] --;
            wordScore += score[ch - 'a'];
        }
        int wordIncluded = 0;
        if (flag == true) {
            wordIncluded = wordScore + findMaxScore(words, frequencyCharacters, score, index + 1);
        }

        // since we will be backtracking undo the changes for frequencyCharacters
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            frequencyCharacters[ch - 'a'] ++;
        }
        return Math.max(wordNotIncluded, wordIncluded);
    }
}
