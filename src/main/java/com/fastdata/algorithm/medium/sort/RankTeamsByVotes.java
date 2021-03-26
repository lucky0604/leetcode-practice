package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/rank-teams-by-votes/
 * @Date: create in 3/26/21 - 11:36 AM
 */
// TODO: to be understand
public class RankTeamsByVotes {

    public String rankTeams(String[] votes) {
        int ranks = votes[0].length();
        List<Character> allCandidates = strToList(votes[0]);
        int[][] ranking = new int[ranks][26];
        for (String v: votes) {
            for (int i = 0; i < v.length(); i ++) {
                ranking[i][v.charAt(i) - 'A'] ++;
            }
        }
        allCandidates.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                for (int i = 0; i < ranks; i ++) {
                    if (ranking[i][o1 - 'A'] != ranking[i][o2 - 'A']) {
                        return ranking[i][o2 - 'A'] - ranking[i][o1 - 'A'];
                    }
                }
                return o1 - o2;
            }
        });
        return listToString(allCandidates);
    }

    private String listToString(List<Character> candidates) {
        StringBuilder sb = new StringBuilder();
        for (Character c: candidates) {
            sb.append(c);
        }
        return sb.toString();
    }

    private List<Character> strToList(String str) {
        List<Character> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            list.add(c);
        }
        return list;
    }
}
