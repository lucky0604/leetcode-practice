package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 * @Date: create in 3/27/21 - 9:46 AM
 */
// TODO: to be understand
public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> companiesSets = new ArrayList<>();
        for (List<String> companyList: favoriteCompanies) {
            companiesSets.add(new HashSet(companyList));
        }

        int[] indexes = new int[favoriteCompanies.size()];
        for (int i = 0; i < indexes.length; i ++)
            indexes[i] = i;
        for (int i = 0 ; i < indexes.length; i ++) {
            for (int j = i + 1; j < indexes.length; j ++) {
                int s1 = find(indexes, i);
                int s2 = find(indexes, j);
                if (s1 == s2) {
                    continue;
                }
                if (contains(companiesSets.get(s1), companiesSets.get(s2))) {
                    indexes[s2] = s1;
                } else if (contains(companiesSets.get(s2), companiesSets.get(s1))) {
                    indexes[s1] = s2;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < indexes.length; i ++) {
            if (i == indexes[i])
                ret.add(i);
        }
        return ret;
    }

    // union find
    int find(int[] indexes, int x) {
        if (indexes[x] != x)
            indexes[x] = find(indexes, indexes[x]);
        return indexes[x];
    }

    boolean contains(Set<String> s1, Set<String> s2) {
        if (s1.size() <= s2.size())
            return false;
        return s1.containsAll(s2);
    }
}
