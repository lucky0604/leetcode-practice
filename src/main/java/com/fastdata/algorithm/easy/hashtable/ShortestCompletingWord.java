package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/shortest-completing-word/
 * @Date: created in 2021/2/14 - 12:32
 */
public class ShortestCompletingWord {

    public static void main(String[] args) {
        String[] words = new String[]{"step","steps","stripe","stepple"};
        String licensePlate = "1s3 PSt";
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> licencePlateMap = new HashMap<>();
        HashMap<Character, Integer> currWordMap = new HashMap<>();
        int characterLength = Integer.MAX_VALUE;
        String sol = "";

        // license plate map population
        // corner case need to clean for numbers
        licensePlate = licensePlate.replaceAll("[0-9]", "");
        // clean for spaces
        licensePlate = licensePlate.replaceAll(" ", "");
        // clean for capital letters
        licensePlate = licensePlate.toLowerCase();

        char[] licenceCharArr = licensePlate.toCharArray();
        for (int i = 0; i < licensePlate.length(); i ++) {
            licencePlateMap.put(licenceCharArr[i], licencePlateMap.getOrDefault(licenceCharArr[i], 0) + 1);
        }

        // loop over string and convert it to map
        for (int j = 0; j < words.length; j ++) {
            licenceCharArr = words[j].toCharArray();

            // populate the current word
            currWordMap.clear();
            for (int i = 0; i < licenceCharArr.length; i ++) {
                currWordMap.put(licenceCharArr[i], currWordMap.getOrDefault(licenceCharArr[i], 0) + 1);
            }

            // check against licensePlate
            int wordLen = 1;
            for (Character c: licencePlateMap.keySet()) {
                if (licencePlateMap.get(c) > currWordMap.getOrDefault(c, 0)) {
                    break;
                } else {
                    // if match && length smaller than character length record length and word
                    if (wordLen == licencePlateMap.size() && words[j].length() < characterLength) {
                        characterLength = words[j].length();
                        sol = words[j];
                    }
                    wordLen ++;
                }
            }
        }
        return sol;
    }
}
