package com.fastdata.algorithm.medium.union_find;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/10 22:15
 * @Version: 1.0
 * @description: https://leetcode.com/problems/accounts-merge/
 **/

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailToFirstAccId = new HashMap<>();
        for (int accId = 0; accId < accounts.size(); accId ++) {
            List<String> account = accounts.get(accId);
            for (String email: account.subList(1, account.size())) {
                if (!emailToFirstAccId.containsKey(email)) {
                    emailToFirstAccId.put(email, accId);
                } else {
                    // there's an account with this email already, so use the UF struct to connect them
                    int previousAccountWithThisEmail = emailToFirstAccId.get(email);
                    uf.union(previousAccountWithThisEmail, accId);
                }
            }
        }

        // go through each account and find the UF root and merge
        Map<Integer, Account> rootAccounts = new HashMap<>();
        for (int accId = 0; accId < accounts.size(); accId ++) {
            List<String> account = accounts.get(accId);

            int rootAccId = uf.root(accId);
            if (!rootAccounts.containsKey(rootAccId)) {
                String rootAccountName = accounts.get(rootAccId).get(0);
                rootAccounts.put(rootAccId, new Account(rootAccountName));
            }
            rootAccounts.get(rootAccId).emails.addAll(account.subList(1, account.size()));
        }
        return rootAccounts.values().stream().map(acc -> acc.toStringList()).collect(Collectors.toList());
    }

    static class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int i = root(a);
            int j = root(b);
            parent[i] = j;
        }

        int root(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];  // path compression
                n = parent[n];
            }
            return n;
        }

    }

    static class Account {
        String name;
        SortedSet<String> emails = new TreeSet<>();

        Account(String name) {
            this.name = name;
        }

        List<String> toStringList() {
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            return list;
        }
    }
}
