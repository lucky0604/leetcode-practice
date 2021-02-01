package com.fastdata.algorithm.easy.hashtable;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/subdomain-visit-count/
 * @Date: create in 1/16/21 - 10:09 AM
 */
public class SubdomainVisitCount {
    private static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(cpdomains);
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        for (String str: cpdomains) {
            splitter(str);
        }
        List<String> ret = new ArrayList<>();
        map.forEach((s, integer) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(integer).append(" ").append(s);
            ret.add(sb.toString());
        });
        return ret;
    }

    private static void splitter(String s) {
        int visited = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                visited = Integer.parseInt(s.substring(0, i));
                String link = s.substring(i + 1);
                map.put(link, map.getOrDefault(link, 0) + visited);
            }
            if (s.charAt(i) == '.') {
                String link = s.substring(i + 1);
                map.put(link, map.getOrDefault(link, 0) + visited);
            }
        }
    }
}
