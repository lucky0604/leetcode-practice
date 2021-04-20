package com.fastdata.algorithm.solutions.ch02.section02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_21
 * @create 2021-04-20 上午11:25
 */

public class Solution_2_2_21 {

    public static String checkIfThereAreCommonNames(List<List<String>> names) {
        for (List<String> nameList: names) {
            if (nameList == null || nameList.isEmpty()) {
                return null;
            }
        }

        for (List<String> nameList: names) {
            Collections.sort(nameList);
        }

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < names.size(); i ++) {
            indexes.add(i);
        }

        String commonName = null;

        while (true) {
            if (indexes.get(0) >= names.get(0).size()) {
                break;
            }

            String maxName = findMaxName(names, indexes);
            boolean commonNameFound = areAllCurrentNamesEqual(names, indexes);

            if (commonNameFound) {
                commonName = maxName;
                break;
            }

            for (int i = 0; i < names.size(); i ++) {
                int index = indexes.get(i);
                while (true) {
                    String name = names.get(i).get(index);
                    if (name.compareTo(maxName) < 0) {
                        index ++;
                        indexes.set(i, index);
                    } else {
                        break;
                    }

                    if (index >= names.get(i).size()) {
                        return null;
                    }
                }
            }
        }
        return commonName;
    }

    private static boolean areAllCurrentNamesEqual(List<List<String>> names, List<Integer> indexes) {
        for (int i = 0; i < names.size() - 1; i ++) {
            int index1 = indexes.get(i);
            String name1 = names.get(i).get(index1);

            int index2 = indexes.get(i + 1);
            String name2 = names.get(i + 1).get(index2);
            if (!name1.equals(name2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * find the max name
     * @param names
     * @param indexes
     * @return
     */
    private static String findMaxName(List<List<String>> names, List<Integer> indexes) {
        String maxName = names.get(0).get(indexes.get(0));
        for (int i = 1; i < names.size(); i ++) {
            int index = indexes.get(i);
            String name = names.get(i).get(index);
            if (name.compareTo(maxName) > 0) {
                maxName = name;
            }
        }
        return maxName;
    }
}
