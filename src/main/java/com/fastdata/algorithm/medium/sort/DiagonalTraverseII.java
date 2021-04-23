package com.fastdata.algorithm.medium.sort;


import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/diagonal-traverse-ii/
 * @Date: create in 4/2/21 - 10:21 AM
 */
public class DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        /**
         * too slow
         */
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        int length = 0;
//        for (int i = 0; i < nums.size(); i ++) {
//            for (int j = 0; j < nums.get(i).size(); j ++) {
//                List<Integer> list = new ArrayList<>();
//                if (map.containsKey(i + j)) {
//                    list = map.get(i + j);
//                    list.add(nums.get(i).get(j));
//                    map.put(i + j, list);
//                } else {
//                    list.add(nums.get(i).get(j));
//                    map.put(i + j, list);
//                }
//                length ++;
//            }
//        }
//        List<Integer> tmp = new ArrayList<>();
//        for (Map.Entry<Integer, List<Integer>> item: map.entrySet()) {
//            Collections.sort(item.getValue(), new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return -1;
//                }
//            });
//            for (int i = 0; i < item.getValue().size(); i ++) {
//                tmp.add(item.getValue().get(i));
//            }
//        }
//        int[] ret = new int[length];
//        for (int i = 0; i < length; i ++) {
//            ret[i] = tmp.get(i);
//        }
//        return ret;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i ++) {
            List<Integer> node = nums.get(i);
            for (int j = 0; j < node.size(); j ++) {
                list.add(new Node(i, i + j, node.get(j)));
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int result = Integer.compare(o1.sum, o2.sum);
                if (result == 0) return Integer.compare(o2.row, o1.row);
                return result;
            }
        });
        int length = list.size();
        int[] ret = new int[length];
        for (int i = 0; i < length; i ++) {
            ret[i] = list.get(i).val;
        }
        return ret;
    }

    class Node {
        int row;
        int sum;
        int val;
        Node(int row, int sum, int val) {
            this.row = row;
            this.sum = sum;
            this.val = val;
        }
    }
}
